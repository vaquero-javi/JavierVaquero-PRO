import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.net.ServerSocket

fun main() {
    val servidor = ServerSocket(12345)
    val cliente = servidor.accept()
    val input: InputStream = cliente.getInputStream()
    val fichero = FileOutputStream("imagen.png")
    val buffer = BufferedOutputStream(fichero)

    val temporal = ByteArray(4096)
    var byte: Int

    while (input.read(temporal).also { byte = it } != -1) {
        buffer.write(temporal,0, byte)
    }

    buffer.flush()
    buffer.close()
    cliente.close()
    servidor.close()
}