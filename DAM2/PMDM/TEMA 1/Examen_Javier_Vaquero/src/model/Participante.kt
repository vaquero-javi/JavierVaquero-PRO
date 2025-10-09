package model

abstract class Participante (
    var nombre: String,
    var plantilla: ArrayList<Jugador>,
    var puntos: Int,
    var presupuesto: Double,
    var id: Int){
    /*
    constructor(
        nombre: String,
        plantilla: ArrayList<Jugador>,
        puntos: Int,
        presupuesto: Double,
        id: Int): this(nombre, plantilla, puntos, presupuesto, id){

        }
     */

    open fun mostrarDatos(){
        println("Nombre : $nombre")
        println("Plantilla : $plantilla")
        println("Puntos : $puntos")
        println("Presupuesto : $presupuesto")
        println("Id : $id")
    }
}