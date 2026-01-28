import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun sha512(texto: String ): String{
    val sha = MessageDigest.getInstance("md5")
    val claveBytes = sha.digest(texto.toByteArray(Charsets.UTF_8))
    return claveBytes.joinToString(""){"%02x".format(it)}
}

fun hMac(key:String,texto: String): String{
    val hmac = Mac.getInstance("HmacMD5")
    hmac.init(SecretKeySpec(key.toByteArray(),"HmacMD5"))
    return hmac.doFinal(texto.toByteArray()).joinToString(""){"%02x".format(it)}
}

fun main() {
    println(sha512("hola"))
    println(hMac("1234","hola"))
}