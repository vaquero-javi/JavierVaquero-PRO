import model.Persona
import model.Trabajador

fun main() {
    //var persona = Persona("Javi","Vaquero","123456A")
    //var persona = Persona("Javi","Vaquero","123456A", 123456789, "javiervaquero@gmail.com")
    var trabajador = Trabajador ("Javi","Vaquero","1234A",40000,
        12, 9111111, "javi@vaquero.com",true)
    trabajador.mostrarDatos()
}