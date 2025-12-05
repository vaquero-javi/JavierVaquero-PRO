import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket

fun main() {
    try {
        val socketmulticast = MulticastSocket(5000)
        val direccion = InetAddress.getByName("224.0.0.3")

        socketmulticast.joinGroup(direccion)

        val mensaje = "hoola".toByteArray()
        val packet = DatagramPacket(mensaje, mensaje.size, direccion, 5000)
        socketmulticast.send(packet)

        while (true){
            val bytes = ByteArray(1024)
            val paqueteRecibido = DatagramPacket(bytes, bytes.size)
            socketmulticast.receive(paqueteRecibido)
            println(String(paqueteRecibido.data, paqueteRecibido.offset, paqueteRecibido.length))
        }
    }catch (e: Exception){
        e.printStackTrace()
    }
}