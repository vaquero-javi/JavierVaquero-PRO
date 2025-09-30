import java.io.*

fun main() {
    val procesoHijo = ProcessBuilder(
        "C:\\Users\\javie\\.jdks\\openjdk-24.0.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2024.3.5\\lib\\idea_rt.jar=61057\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\\Users\\javie\\OneDrive\\Documentos\\GitHub\\JavierVaquero-PRO\\DAM2\\PSP\\Ejercicio2\\out\\production\\Ejercicio2;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\2.1.10\\kotlin-stdlib-2.1.10.jar;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar HijoKt"
    ).start()
    val writerHijo = BufferedWriter(OutputStreamWriter(procesoHijo.outputStream))
    val readerHijo = BufferedReader(InputStreamReader(procesoHijo.inputStream))

    val procesoAbuelo = ProcessBuilder(
        "C:\\Users\\javie\\.jdks\\openjdk-24.0.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2024.3.5\\lib\\idea_rt.jar=54666\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\\Users\\javie\\OneDrive\\Documentos\\GitHub\\JavierVaquero-PRO\\DAM2\\PSP\\Ejercicio2\\out\\production\\Ejercicio2;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\2.1.10\\kotlin-stdlib-2.1.10.jar;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar AbueloKt"
    ).start()
    val writerAbuelo = BufferedWriter(OutputStreamWriter(procesoAbuelo.outputStream))
    val readerAbuelo = BufferedReader(InputStreamReader(procesoAbuelo.inputStream))

    val teclado = BufferedReader(InputStreamReader(System.`in`))

    println("Padre inicia la conversación. Escribe 'salir' para terminar.")

    while (true) {
        print("Padre -> ")
        val mensaje = teclado.readLine() ?: break
        if (mensaje.lowercase() == "salir") break

        writerHijo.write(mensaje + "\n")
        writerHijo.flush()
        val respHijo = readerHijo.readLine()
        if (respHijo != null) println(respHijo)

        writerAbuelo.write(mensaje + "\n")
        writerAbuelo.flush()
        val respAbuelo = readerAbuelo.readLine()
        if (respAbuelo != null) println(respAbuelo)
    }

    println("Conversación terminada.")

}
