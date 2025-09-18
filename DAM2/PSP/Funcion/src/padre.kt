import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val proceso = ProcessBuilder("C:\\Users\\javie\\.jdks\\openjdk-24.0.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2024.3.5\\lib\\idea_rt.jar=56848\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\\Users\\javie\\OneDrive\\Documentos\\GitHub\\JavierVaquero-PRO\\DAM2\\PSP\\Funcion\\out\\production\\Funcion;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\2.1.10\\kotlin-stdlib-2.1.10.jar;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar HijoKt")
    val procesoEjecutado = proceso.start()

    val output = OutputStreamWriter(procesoEjecutado.outputStream)
    output.write("hola hijo\n")
    output.flush()

    val input = BufferedReader(InputStreamReader(procesoEjecutado.inputStream)).readLine()
    print(input)
}