import java.io.ObjectOutputStream
import java.net.Socket

class ClienteO {
    fun envirObjeto(persona: Persona){
        val cliente = Socket("127.0.0.1",1238)
        val enviar = ObjectOutputStream(cliente.getOutputStream())
        enviar.writeObject(persona)
        enviar.flush()
        enviar.close()
        cliente.close()
    }
}