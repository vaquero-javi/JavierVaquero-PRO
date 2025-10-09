fun main() {
    val tortuga = Thread {
        for (i in 1..10) {
            println("La tortuga avanza paso $i")
            Thread.sleep(500)
        }
        println("¡La tortuga ha llegado a la meta!")
    }

    val liebre = Thread {
        for (i in 1..10) {
            println("La liebre avanza salto $i")
            Thread.sleep(200)
            if (i == 5) {
                println("La liebre se duerme un rato...")
                Thread.sleep(1500)
            }
        }
        println("¡La liebre ha llegado a la meta!")
    }

    tortuga.start()
    liebre.start()

    tortuga.join()
    liebre.join()

    println("¡La carrera ha terminado!")
}
