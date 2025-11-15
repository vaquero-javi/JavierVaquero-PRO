import java.awt.MouseInfo
import java.net.InetAddress
import java.net.ServerSocket
import java.io.BufferedReader
import java.io.InputStreamReader
import java.awt.Robot
import java.awt.event.InputEvent
import java.util.concurrent.Executors

fun main() {
    val puerto = 6000
    val threadPool = Executors.newFixedThreadPool(10) // Pool para múltiples clientes

    try {
        val inetAddress: InetAddress = InetAddress.getByName("169.254.223.161")
        val servidor = ServerSocket(puerto, 50, inetAddress)
        println("🖥️ Servidor multi-cliente iniciado en ${servidor.inetAddress.hostAddress}:${servidor.localPort}")
        println("👥 Esperando conexiones de múltiples clientes...")

        val robot = Robot()

        while (true) {
            val cliente = servidor.accept()
            println("✅ Nuevo cliente conectado: ${cliente.inetAddress.hostAddress}:${cliente.port}")

            // Manejar cada cliente en un hilo separado
            threadPool.execute {
                manejarCliente(cliente, robot)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun manejarCliente(cliente: java.net.Socket, robot: Robot) {
    val clientId = "${cliente.inetAddress.hostAddress}:${cliente.port}"

    try {
        val inputStream = cliente.getInputStream()
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))

        var mensajeRecibido: String?
        while (bufferedReader.readLine().also { mensajeRecibido = it } != null) {
            println("📨 Mensaje de $clientId: $mensajeRecibido")
            interpretarDireccion(mensajeRecibido, robot, clientId)
        }

    } catch (e: Exception) {
        println("❌ Error con cliente $clientId: ${e.message}")
    } finally {
        try {
            cliente.close()
            println("🔌 Cliente $clientId desconectado")
        } catch (e: Exception) {
            // Ignorar errores al cerrar
        }
    }
}

fun interpretarDireccion(direccion: String?, robot: Robot, clientId: String) {
    direccion?.let {
        val currentPosition = MouseInfo.getPointerInfo().location
        val x = currentPosition.x
        val y = currentPosition.y

        when (it) {
            "izquierda" -> {
                robot.mouseMove(x - 10, y)
                println("🖱️ Cliente $clientId movió a la IZQUIERDA")
            }
            "derecha" -> {
                robot.mouseMove(x + 10, y)
                println("🖱️ Cliente $clientId movió a la DERECHA")
            }
            "arriba" -> {
                robot.mouseMove(x, y - 10)
                println("🖱️ Cliente $clientId movió hacia ARRIBA")
            }
            "abajo" -> {
                robot.mouseMove(x, y + 10)
                println("🖱️ Cliente $clientId movió hacia ABAJO")
            }
            "click" -> {
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
                println("🖱️ Cliente $clientId hizo CLICK")
            }
            else -> {
                println("⚠️ Comando desconocido de $clientId: $it")
            }
        }
    }
}
