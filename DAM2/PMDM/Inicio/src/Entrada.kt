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

    //Hola soy Javi, tengo 23 años y mi DNI es 123456A
    println("Hola mi nombre es $nombre, tengo $edad y mi DNI es $DNI")
    println("Mi nombre tiene ${nombre.length} letras")
    println("Mi correo es ${correo?.length ?: "Sin asignado"}")
    direccion = "Alcorcon"
    println("Mi direccion es $direccion")

}