import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry

fun main() {
    try {
        val registro: Registry = LocateRegistry.getRegistry("127.0.0.1",2020)
        val sumaRemota= registro.lookup("sumaRemota") as SumRemota
        println(sumaRemota.suma(5,8))
    }catch (e: Exception){
        println(e.printStackTrace())
    }
}