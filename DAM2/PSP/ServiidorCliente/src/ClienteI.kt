import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.OutputStream
import java.net.Socket

fun main() {
    val cliente = Socket("127.0.0.1",12345)
    val fichero = File("cara.png")
    val output: OutputStream = cliente.getOutputStream()

    val ficherostream = FileInputStream(fichero)
    val bufferinput = BufferedInputStream(ficherostream)

    val temporal = ByteArray(4096)
    var byte: Int

    while (bufferinput.read(temporal).also { byte = it } != -1) {
        output.write(temporal,0, byte)
    }
}