import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val job =  launch{
            println("Incio de corrutina")
            for (i in 1..10){
                println("Estoy ejecutando la corrutina")
                delay(1000L)
            }
        }
        job.join()
        for (i in 1..10){
            println("Estoy ejecutando el principal")
            Thread.sleep(1000L)
        }
    }
}