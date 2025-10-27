import java.util.concurrent.CountDownLatch

fun main() {
    val interruptor = CountDownLatch(3)  //contador

    fun tarea(){
        interruptor.countDown()  //para decrementar el contador
        println("He empezado a ejecutar")
        Thread.sleep(1000)
        println("He acabado de ejecutar")
    }

    val hilo1 = Thread{tarea()}
    val hilo2 = Thread{tarea()}
    val hilo3 = Thread{tarea()}
    val hilo4 = Thread{tarea()}

    hilo1.start()
    hilo2.start()
    hilo3.start()
    interruptor.await()
    hilo4.start()
    interruptor.await()

}

