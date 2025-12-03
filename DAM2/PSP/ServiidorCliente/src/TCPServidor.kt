import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

class TCPServidor {
    fun startServer() = runBlocking{
        try {
            val server= ServerSocket(5000)
            while (true) {
                val cliente = server.accept()
                launch (Dispatchers.IO) {
                val leer = BufferedReader(InputStreamReader(cliente.getInputStream()))
                val escribir = PrintWriter(cliente.getOutputStream(), true)
                var mensaje: String?
                do {
                    mensaje = leer.readLine()
                    println(mensaje)
                    escribir.print("Mesnaje recibido: $mensaje\n")
                } while (mensaje != null && mensaje != "fin")
                leer.close()
                escribir.close()
                cliente.close()
                server.close()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}

fun main(){
    val server = TCPServidor().startServer()
}