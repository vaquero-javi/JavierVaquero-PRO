import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry

fun main() {
    val sumaRemota = SumaRemotaImpl()
    try {
        val resgistro: Registry = LocateRegistry.createRegistry(2020)
        resgistro.bind("SumaRemota", sumaRemota)
        print("Servidor RMI iniciado")
    }catch (e: Exception){
        e.printStackTrace()
    }
}