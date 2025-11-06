import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL

fun main() {
    val url = URI ("https://contries.trevorblades.com/").toURL()
    val query ="""
    {
        "query": "query {contries {name code}"
    }
    """".trimIndent()


    val conexion = url.openConnection() as HttpURLConnection

    conexion.requestMethod = "POST"
    conexion.setRequestProperty("Content-Type","application/json")

    conexion.doOutput = true
    val out  = conexion.getOutputStream()
    out.write(query.toByteArray())
    out.flush()
    out.close()


}