package model

class Jugador( nombre: String, plantilla: ArrayList<Jugador>,
               puntos: Int, presupuesto: Double, id: Int, posicion: String) :
    Plantilla(nombre,plantilla,puntos,presupuesto,id,posicion) {

    constructor(id: Int,nombre: String,posicion: String, presupuesto: Double) :
            this(id,nombre,presupuesto){
        posicion
    }

    constructor(id: Int, nombre: String, puntos: Int) :
            this(id, nombre, puntos) {}
}