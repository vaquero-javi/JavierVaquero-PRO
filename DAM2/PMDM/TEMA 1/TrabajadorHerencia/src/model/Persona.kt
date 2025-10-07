package model

abstract class Persona (var nombre : String, var apellido : String, var DNI : String) {
    //nombre, apellido, DNI-> obligatorio
    // telefono, correo ->opcional

    var telefono : Int? = null

    var correo : String? = null

    constructor(nombre: String,apellido: String,DNI: String, telefono: Int, correo: String):this(
        nombre, apellido, DNI){
        this.telefono = telefono
        this.correo = correo
    }

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $DNI")
        println("El telefono es $telefono?: no se ha especificado")
        println("El correo es $correo?: no se ha especificado")
    }
}