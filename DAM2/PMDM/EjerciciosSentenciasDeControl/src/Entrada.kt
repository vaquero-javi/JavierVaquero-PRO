fun main() {
    //Ejercicio1()
    //Ejercicio2()
    //Ejercicio3()
    //Ejercicio4()
    //Ejercicio5()
    //Ejercicio6()
    Ejercicio7()
}

fun Ejercicio1(){
    println("Escribe un programa que lea un número entero y que indique si es par o impar.")
    val numero: Int = readLine()!!.toInt();
    val par: Boolean = numero % 2 == 0

    if (par){
        println("El número es par")
    }else{
        println("El número es impar")
    }
}

fun Ejercicio2(){
    println("Escribe un programa que lea un número entero y que indique si es positivo, negativo o cero.")
    val numero: Int = readLine()!!.toInt()
    if (numero > 0){
        println("El número es positivo")
    }else if (numero < 0){
        println("El número es negativo")
    }else{
        println("El número es 0")
    }
}

fun Ejercicio3(){
    println("Escribe un programa que lea un número entero y que indique si es primo o no.")
    val num: Int = readLine()!!.toInt()
    var resto:Int = 0
    for (i in num downTo  1 ){
        var division: Int = num % i
        if (division == 0){
            resto++
        }
    }
    if (resto == 1 || resto == 2){
        println("El número es primo")
    }else{
        println("El número no es primo")
    }
}

fun Ejercicio4(){
    println("Escribe un programa que lea un número entero y que muestre por pantalla todos los " +
            "números primos menores o iguales al número leído.")
    println("Introduce un número para saber todos los numeros primos menores o iguales ")
    val num: Int = readLine()!!.toInt()
    for (i in num downTo  1 ){
        var division: Int = num % i
        if (division == 0){
            println(i)
        }
    }
}

fun Ejercicio5(){
    println("Escribe un programa que lea un número entero y que calcule el factorial de ese número.")
    println("Introduce un numero")
    val num: Int = readLine()!!.toInt()
    var valorAbsoluto: Int = 0
    var contador:Int = num
    if (num == 1 || num == 0){
        valorAbsoluto = 1
        println("El valor absoluto del numero $num es $valorAbsoluto")
    }else{
        for (i in num -1 downTo 1){
            valorAbsoluto = contador * i
            contador = valorAbsoluto
        }
        println("El valor absoluto del numero $num es $valorAbsoluto")
    }
}

fun Ejercicio6(){
    println("Escribe un programa que lea un número entero y que calcule la suma de los primeros N números naturales.")
    println("Introduce un numero ")
    val num:Int = readLine()!!.toInt()
    var valorAbsoluto: Int = 0
    var contador:Int = num
    for (i in num -1  downTo 1){
        valorAbsoluto = contador + i
        contador = valorAbsoluto
    }
    println("La suma de los primeros $num naturales son $valorAbsoluto")
}

fun Ejercicio7(){
    println("Escribe un programa que lea un número entero y que calcule la suma de los dígitos de ese número.")
    val num:Int = readLine()!!.toInt()

}