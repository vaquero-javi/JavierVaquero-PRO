import java.security.Key
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec

fun generarAESclave(): Key = KeyGenerator.getInstance("AES").apply { init(128) }.generateKey()

fun cifrar(texto:String, clave: Key): ByteArray{
    //seleccionar algoritmo de cifrado
    val cifrado = Cipher.getInstance("AES/CBC/PKCS5Padding")
    cifrado.init(Cipher.ENCRYPT_MODE, clave)
    val iv = cifrado.iv
    val textoCifrado = cifrado.doFinal(texto.toByteArray())
    return iv + textoCifrado
}

fun descrifrar(dato: ByteArray, key: Key): String{
    val iv = dato.copyOf(0,16)
    val cifrado = dato.copyOfRange(16, dato.size)
    val descifrar = Cipher.getInstance("AES/CBC/PKCS5Padding")
    val i
    descifrar.init(Cipher.DECRYPT_MODE,key, )
    return String(descrifrar.doFinal(cifrado))
}

fun main(){
    val clave = generarAESclave()
    val textoCifrado = cifrar("hola", generarAESclave())
    println(Base64.getEncoder().encodeToString(textoCifrado))
    val textodescifrado = descrifrar(textoCifrado, clave)
    println()
}