fun main() {

    //imprimir por consola
    println("Este es mi primer programa Kotlin")

    //tipos de variables
        //var-mutable
        //val-nomutable (constante)
    var nombre = "Javi" //String
    var edad = 23 //Int
    var correo: String? = null  // Donde pone String? significa que es string o nulo
    lateinit var direccion: String
    val DNI ="123456A"

    println("Por favor introduce tu nombre")
    nombre = readln()
    println("Por favor introduce tu edad")
    edad = readln().toInt()

    saludar(nombreParam = nombre, vecesParam = 1)
    println("La suma de la operacion es ${sumar(4,7)}")
    sumaFlecha(1,55)
    


/*
    //Hola soy Javi, tengo 23 años y mi DNI es 123456A
    println("Hola mi nombre es $nombre, tengo $edad y mi DNI es $DNI")
    println("Mi nombre tiene ${nombre.length} letras")
    println("Mi correo es ${correo?.length ?: "Sin asignado"}")
    direccion = "Alcorcon"
    println("Mi direccion es $direccion")
*/
}

fun  saludar(nombreParam: String, vecesParam:Int){
    println("Hola $nombre, acabas de realizar una función ")
}

fun sumar(op1: Int, op2: Int): Int {
    return op1+op2
}

val sumaFlecha = {p1:Int, p2:Int ->
    println("El resultado de la suma es ${p1+p2}")
}

fun decicirWhen(valor:int){     //when en kotlin = switch en java
    println("El valor analizado es: ")
    when(valor){
        1->{
            println("El caso tiene como valor 1")
        }
        2->{
            println("El caso tiene como valor 2")
        }
        3->{
            println("El caso tiene como valor 3")
        }
        4->{
            println("El caso tiene como valor 4")
        }
        sumar(1,4)->{
            println("El caso tiene como valor 5")
        }
        else-> println("Caso no contemplado")
    }
}

fun repetirFor(){
    for (i in 0..9 step 2){
        println(i)
    }
}

fun repetirForEach(){
    //si la funcion de flecha solo tiene 1 argumento este se puede llamar con la palabra reservada it
    (20..30).forEach { p-> println(p) }
    (20..30).forEach { println(it) } //esto y la linea de arriba es lo mismo 
    (20..30).forEachIndexed { index, i -> println("El resultado en posicion $index es $i") }
}