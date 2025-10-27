import java.util.Calendar

fun main() {

    Thread{
        val horaActual = Calendar.getInstance().time
        println(horaActual)
    }

}