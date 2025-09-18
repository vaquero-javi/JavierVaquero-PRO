
import java.io.BufferedReader
import java.io.InputStreamReader
/*
fun main(args:Array<String>){
}

    //escribiendo /leyendo el error en el proceso principal
    val nombre = "arp -a"
    val proceso = ProcessBuilder("cmd.exe","/c","arp -a")
    proceso.redirectOutput(ProcessBuilder.Redirect.INHERIT) //escribir
    proceso.redirectError(ProcessBuilder.Redirect.INHERIT)  //leer error

    //leer un proceso
    val nombre = "arp -a"
    val proceso = ProcessBuilder("cmd.exe","/c","arp -a")
    val procesoTemporal = proceso.start()
    print(procesoTemporal.inputStream.bufferedReader().readText())

    //el proceso que quiero mostrar en pantalla llama a algo tarda mucho
    val nombre = "arp -a"
    val proceso = ProcessBuilder("cmd.exe","/c","arp -a")
    val procesoTemporal = proceso.start()
    print(procesoTemporal.isAlive)
    procesoTemporal.waitFor()

    //conexion a un proceso en tiempo real a InputStream y lectura de ello
    val nombre = "arp -a"
    val proceso = ProcessBuilder("C:\\Users\\javie\\.jdks\\openjdk-24.0.1\\bin\\java.exe \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2024.3.5\\lib\\idea_rt.jar=54983\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\\Users\\javie\\OneDrive\\Documentos\\GitHub\\JavierVaquero-PRO\\DAM2\\PSP\\Funcion\\out\\production\\Funcion;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\2.1.10\\kotlin-stdlib-2.1.10.jar;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar LlamarKt").start().inputStream)).readLine()
    val procesoTemporal = proceso.start()
    var lector = BufferedReader(InputStreamReader(procesoTemporal.inputStream))
    var linea:String?
    while (lector.readLine().also { linea = it } !=null){
        println(linea)
    }
}
*/

fun main (args: Array<String>){
    var linea = BufferedReader (InputStreamReader(ProcessBuilder("C:\\Users\\javie\\.jdks\\openjdk-24.0.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2024.3.5\\lib\\idea_rt.jar=49855\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\\Users\\javie\\OneDrive\\Documentos\\GitHub\\JavierVaquero-PRO\\DAM2\\PSP\\Funcion\\out\\production\\Funcion;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\2.1.10\\kotlin-stdlib-2.1.10.jar;C:\\Users\\javie\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar LlamarKt").start().inputStream)).readLine()
    println(linea.uppercase())
}










