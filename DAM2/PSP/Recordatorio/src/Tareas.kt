import java.util.concurrent.Executors

fun main() {
    val ejecutar = Executors.newFixedThreadPool(3)
    val tareas = listOf(
        Tarea("Tarea1"),
        Tarea("Tarea2"),
        Tarea("Tarea3"),
        Tarea("Tarea4"),
        Tarea("Tarea5"),
        Tarea("Tarea6")
    )
    for (tarea in tareas){
        ejecutar.execute(tarea)
    }
    ejecutar.shutdown()
}

class Tarea(private val nombre:String) : Runnable{
    override fun run() {
        println("inicio tarea $nombre")
        for (i in 1..10){
            Thread.sleep(100)
        }
    }
}