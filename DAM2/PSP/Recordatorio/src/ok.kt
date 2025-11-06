import okhttp3.OkHttpClient
import okhttp3.Request

class ok {
    val cliente = OkHttpClient()
    val url = "https://www.marca.com/"
    val peticion = Request.Builder().url(url).build()
    val respuesta = cliente.newCall(peticion).execute()
    println(respuesta.body?.string())

}