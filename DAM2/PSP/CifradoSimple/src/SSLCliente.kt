import java.io.DataInputStream
import java.io.DataOutputStream
import javax.net.ssl.SSLServerSocket
import javax.net.ssl.SSLServerSocketFactory
import javax.net.ssl.SSLSocketFactory

fun main() {

    System.setProperty("javax.net.ssl.trustStore", "Almacen")
    System.setProperty("javax.net.ssl.trustStorePassword", "1234567")

    val socketFactory = SSLSocketFactory.getDefault() as SSLSocketFactory
    val cliente = socketFactory.createSocket("127.0.0.1", 2000)

    val entrada = DataInputStream(cliente.getInputStream())
    val salida = DataOutputStream(cliente.getOutputStream())

    salida.writeUTF("hola servidor")
    salida.flush()
    Thread.sleep(1000)
}