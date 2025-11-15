import java.net.Socket
import java.io.*

fun main() {
    try {
        // Conectar al servidor (IP correcta y puerto)
        val cliente = Socket("127.0.0.1", 12345)

        // Enviar mensaje al servidor
        val writer = PrintWriter(cliente.getOutputStream(), true)
        writer.println("Hola servidor!")

        // Leer respuesta del servidor
        val reader = BufferedReader(InputStreamReader(cliente.getInputStream()))
        val respuesta = reader.readLine()
        println("📨 Respuesta del servidor: $respuesta")

        // Cerrar conexión
        reader.close()
        writer.close()
        cliente.close()

    } catch (e: Exception) {
        println("❌ Error conectando al servidor: ${e.message}")
    }
}