

fun cifrar(palabra: String, desplazamiento: Int): String{
    return palabra.map { (it + desplazamiento).toChar() }.joinToString ("")
}

fun descifrar(palabra: String, desplazamiento: Int): String{
    return palabra.map { (it - desplazamiento).toChar() }.joinToString ("")

}

fun main() {
    println(cifrar("Hola",2))
    println(descifrar(cifrar("Hola", 2),2))
}