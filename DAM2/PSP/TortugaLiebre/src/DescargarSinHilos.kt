import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

fun descargar(){
    println("comienzo a descargar")
    TimeUnit.SECONDS.sleep(2)
    println("lo he descargado")
}

fun main() {
    val tiempo = measureTimeMillis {
        for (i in 1..10){
        descargar()
        }
    }
    println(tiempo)
}