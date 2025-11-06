import okio.IOException
import java.net.Socket
import java.net.UnknownHostException

fun main() {
    try {
        val cliente = Socket("192.168.2.216", 80)
        println(cliente.getOutputStream())
        println("Ha funcionado")
    }catch (e: UnknownHostException){
        println(e)
    }catch (e: IOException){
        println("No ha podido abrir el puerto")
    }
}