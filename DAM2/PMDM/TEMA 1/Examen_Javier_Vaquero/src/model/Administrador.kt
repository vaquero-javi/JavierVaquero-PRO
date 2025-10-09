package model

class Administrador(
    nombre: String, plantilla?: ArrayList<Jugador>,
    puntos?: Int, presupuesto?: Double, id: Int, var clave:Int) : Participante(
        nombre,plantilla,puntos,presupuesto,id) {

        constructor(id: Int, nombre: String, clave: Int) :
         this(id, nombre){
             this.clave = clave
         }

    fun iniciarLiga(){
        var intentos:Int=3
        println("Introduce la clave para iniciar la liga")
        clave = readln().toInt()
        if (clave != 1234){
            println("Error, no puedes iniciar la liga ")
            println("Te quedan $intentos intentos para poner bien la clave")
            intentos--
            if (intentos<0){
                println("Se te acabaron las oportunidades, no puedes hacer mas intentos")
            }
        }else{
            println("Bienvenido a la Liga Fantasy")
            println("Introduce tu nombre")
            nombre= readln()
            println("Introduce tu id")
        }

     }
}