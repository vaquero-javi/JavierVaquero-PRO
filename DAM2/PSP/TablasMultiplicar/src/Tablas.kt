//haz las tablas de multiplicar del 1 al 10 con hilos en orden (ejemplo 1x1, 1x2, 1x3... 2x1, 2x2, 2x3...)
fun main() {
    val hilos = mutableListOf<Thread>()
    for (i in 1..10) {
        for (j in 1..10) {
            val hilo = Thread {
                println("$i x $j = ${i * j}")
            }
            hilos.add(hilo)
            hilo.start()
            hilo.join()
        }
    }
}

