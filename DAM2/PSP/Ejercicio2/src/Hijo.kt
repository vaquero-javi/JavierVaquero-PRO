import java.io.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val mensaje = reader.readLine() ?: break
        if (mensaje.lowercase() == "salir") break

        writer.write("Hijo responde: Recibido '$mensaje'\n")
        writer.flush()
    }
}
