import java.security.MessageDigest

fun main() {
    val palabra = "hola"

    val instancia = MessageDigest.getInstance("SHA-256")

    val hash = instancia.digest(palabra.toByteArray())

    println(hash.joinToString(""){"%02x".format(it)})
}