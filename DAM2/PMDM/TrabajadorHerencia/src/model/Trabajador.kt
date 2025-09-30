package model

class Trabajador(nombre:String, apellido:String, DNI:String, var salario:Int, var numPagas:Int) :
    Persona(nombre,apellido,DNI) {
    //nombre,apellido,dni, SALARIO, NUMPAGAS ->obligatorio
    //tel, email, SEGURO -> opcional
        var seguro : Boolean = false

    constructor(
        nombre: String, apellido: String, DNI: String, salario: Int,
        numPagas: Int, telefono:Int, correo:String ,seguro: Boolean) :this(nombre, apellido, DNI, salario, numPagas){
        this.seguro = seguro
        this.telefono = telefono
        this.correo = correo
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario: $salario")
        println("Numero de pagas : $numPagas")
        println("Seguro : $seguro")
    }
}

