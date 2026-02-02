import java.security.Key
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import java.util.Base64
import javax.crypto.spec.IvParameterSpec

fun generarAESclave(): Key = KeyGenerator.getInstance("AES").apply {
    init(128) }.generateKey()

fun cifrar(texto:String,clave:Key): ByteArray{
    //seleccionar algoritmo de cifrado
    val cifrado = Cipher.getInstance("AES/CBC/PKCS5Padding")
    //inicio el modo de cifrado con clave
    cifrado.init(Cipher.ENCRYPT_MODE,clave)
    val iv = cifrado.iv
    val textocifrado = cifrado.doFinal(texto.toByteArray())
    return iv + textocifrado
}

fun descifrar(dato: ByteArray, key: Key):String {
    val iv = dato.copyOfRange(0,16)
    val cifrado = dato.copyOfRange(16,dato.size)
    val descifrar = Cipher.getInstance("AES/CBC/PKCS5Padding")
    //inicio el modo de cifrado con clave
    descifrar.init(Cipher.DECRYPT_MODE,key, IvParameterSpec(iv))
    return String(descifrar.doFinal(cifrado))
}

fun main(){
    val clave = generarAESclave()
    val textocifrado = cifrar("hola",clave)
    val cifrado = Base64.getEncoder().encodeToString(textocifrado)
    val textodescifrado = descifrar(textocifrado,clave)
    println(cifrado)
    println(textodescifrado)
}