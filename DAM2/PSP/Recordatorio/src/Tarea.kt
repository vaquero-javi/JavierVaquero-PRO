import java.util.concurrent.Executor
import java.util.concurrent.Executors

fun main() {
    val ejecutar = Executors.newSingleThreadExecutor()
    ejecutar.execute{
        println("Soy un hilo")
        // todo lo que nos apetezca
    }
    ejecutar.shutdown()

}