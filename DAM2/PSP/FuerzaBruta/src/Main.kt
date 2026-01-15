import java.security.MessageDigest

class FuerzaBrutaSHA256 {

    // Calcula el hash SHA-256 de un texto
    fun sha256(texto: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(texto.toByteArray(Charsets.UTF_8))
        return hashBytes.joinToString("") { "%02x".format(it) }
    }

    // Fuerza bruta: prueba combinaciones de 0000 a 9999
    fun fuerzaBruta(hashObjetivo: String) {
        for (i in 0..9999) {
            val intento = i.toString().padStart(4, '0')
            val hashIntento = sha256(intento)
            println()

            if (hashIntento == hashObjetivo) {
                println("✔ Hash encontrado")
                println("Contraseña: $intento")
                return
            }
        }
        println("❌ No se encontró la contraseña")
    }
}

fun main() {
    val fuerzaBruta = FuerzaBrutaSHA256()

    // Simulamos una contraseña real (el atacante NO la conoce)
    val passwordReal = "0423"

    // Se genera el hash (como estaría en una base de datos)
    val hashObjetivo = fuerzaBruta.sha256(passwordReal)

    println("Hash objetivo: $hashObjetivo")
    println("Iniciando fuerza bruta...\n")

    // Ataque por fuerza bruta
    fuerzaBruta.fuerzaBruta(hashObjetivo)
}



