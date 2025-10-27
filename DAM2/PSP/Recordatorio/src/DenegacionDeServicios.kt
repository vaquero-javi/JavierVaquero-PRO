import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.Callback
import java.io.File
import java.io.IOException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Semaphore
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureNanoTime
import kotlin.math.roundToLong

fun main() {
    // ---------- CONFIG ----------
    val url = "http://192.168.2.216/"    // tu IP
    val totalRequests = 1_000_000        // total que quieres hacer (ej. 1_000_000)
    val batchSize = 50_000               // peticiones por lote (ajusta)
    val maxInflight = 1000               // máximo peticiones simultáneas en vuelo
    val timeoutSeconds = 20
    val saveCsv = true
    val pauseBetweenBatchesMs = 200L     // pausa breve entre lotes (reducción de ráfaga)
    // ------------------------------

    val client = OkHttpClient.Builder()
        .connectTimeout(timeoutSeconds.toLong(), TimeUnit.SECONDS)
        .readTimeout(timeoutSeconds.toLong(), TimeUnit.SECONDS)
        .build().also {
            // Ajustes internos del dispatcher (buena práctica)
            it.dispatcher.maxRequests = maxInflight
            it.dispatcher.maxRequestsPerHost = maxInflight
        }

    val success = AtomicInteger(0)
    val failure = AtomicInteger(0)
    val statusCounts = mutableMapOf<Int, AtomicInteger>()
    val latencies = mutableListOf<Long>() // nanosegundos; sincronizar acceso
    val semaphore = Semaphore(maxInflight) // controla in-flight
    val startAll = System.nanoTime()

    var remaining = totalRequests
    var batchIndex = 0

    while (remaining > 0) {
        batchIndex++
        val currentBatch = minOf(batchSize, remaining)
        println("Lanzando lote #$batchIndex -> $currentBatch peticiones (remaining=${remaining - currentBatch})")

        // Latch para esperar a que terminen todas las peticiones del lote
        val latch = CountDownLatch(currentBatch)

        repeat(currentBatch) {
            // controla que no pasemos maxInflight simultáneas (backpressure)
            semaphore.acquire()

            val req = Request.Builder().url(url).build()
            val startNano = System.nanoTime()

            client.newCall(req).enqueue(object : Callback {
                override fun onFailure(call: okhttp3.Call, e: IOException) {
                    failure.incrementAndGet()
                    // registrar latencia aproximada
                    val took = System.nanoTime() - startNano
                    synchronized(latencies) { latencies.add(took) }
                    latch.countDown()
                    semaphore.release()
                }

                override fun onResponse(call: okhttp3.Call, response: Response) {
                    try {
                        val code = response.code
                        statusCounts.computeIfAbsent(code) { AtomicInteger(0) }.incrementAndGet()
                        if (response.isSuccessful) success.incrementAndGet() else failure.incrementAndGet()

                        val took = System.nanoTime() - startNano
                        synchronized(latencies) { latencies.add(took) }

                        // consume body to free resources (if large, consider skipping)
                        response.close()
                    } finally {
                        latch.countDown()
                        semaphore.release()
                    }
                }
            })
        }

        // Espera a que termine el lote actual
        latch.await()
        println("Lote #$batchIndex completado.")
        remaining -= currentBatch

        // pausa pequeña para no saturar instantáneamente (opcional)
        if (pauseBetweenBatchesMs > 0 && remaining > 0) {
            Thread.sleep(pauseBetweenBatchesMs)
        }
    }

    val totalSecs = (System.nanoTime() - startAll) / 1_000_000_000.0
    val totalDone = success.get() + failure.get()
    val rps = if (totalSecs > 0) totalDone / totalSecs else 0.0

    // convertir latencias a ms y ordenar
    val latMs = synchronized(latencies) { latencies.map { it / 1_000_000.0 }.sorted() }

    fun percentile(p: Double): Double {
        if (latMs.isEmpty()) return 0.0
        val idx = ((p / 100.0) * (latMs.size - 1)).roundToLong().toInt()
        return latMs[idx]
    }

    println("\n=== RESULTADOS MASIVOS ===")
    println("Total solicitado: $totalRequests")
    println("Completadas: $totalDone (Éxitos: ${success.get()}, Fallos: ${failure.get()})")
    println("Duración total: ${"%.2f".format(totalSecs)} s")
    println("RPS (aprox): ${"%.2f".format(rps)}")
    println("Status codes:")
    statusCounts.entries.sortedBy { it.key }.forEach { (code, cnt) ->
        println("  $code -> ${cnt.get()}")
    }
    println("Latencia ms (avg/min/max): ${"%.2f".format(latMs.averageOrZero())}/${"%.2f".format(latMs.minOrNull() ?: 0.0)}/${"%.2f".format(latMs.maxOrNull() ?: 0.0)}")
    println("p50: ${"%.2f".format(percentile(50.0))}, p90: ${"%.2f".format(percentile(90.0))}, p99: ${"%.2f".format(percentile(99.0))}")

    if (saveCsv) {
        try {
            val f = File("massive_results.csv")
            f.printWriter().use { out ->
                out.println("latency_ms")
                latMs.forEach { out.println("%.4f".format(it)) }
            }
            println("Latencias guardadas en massive_results.csv")
        } catch (e: Exception) {
            println("Error guardando CSV: ${e.message}")
        }
    }

    // limpiar cliente OkHttp
    client.dispatcher.executorService.shutdown()
    client.connectionPool.evictAll()
}

// helper para average con lista vacía
private fun List<Double>.averageOrZero(): Double = if (this.isEmpty()) 0.0 else this.average()
