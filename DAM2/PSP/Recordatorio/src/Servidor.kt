import java.net.ServerSocket
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    try {
        // Crear servidor en puerto 12345
        val servidor = ServerSocket(12345)
        println("🖥️ Servidor iniciado en puerto 12345...")

        // Aceptar conexión de cliente
        val cliente = servidor.accept()
        println("🔗 Cliente conectado: ${cliente.inetAddress.hostAddress}")

        // Leer datos del cliente
        val reader = BufferedReader(InputStreamReader(cliente.getInputStream()))
        val mensaje = reader.readLine()
        println("📨 Mensaje recibido: $mensaje")

        // Escribir respuesta al cliente
        val writer = cliente.getOutputStream().bufferedWriter()
        writer.write("Hola cliente! Recibí tu mensaje\n")
        writer.flush()

        // Cerrar conexiones
        reader.close()
        writer.close()
        cliente.close()
        servidor.close()

    } catch (e: Exception) {
        println("❌ Error: ${e.message}")
    }
}