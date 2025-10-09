package model

class Plantilla(
    nombre: String, plantilla: ArrayList<Jugador>,
    puntos: Int, presupuesto: Double, id: Int, var posicion: String
) :
    Participante(nombre, plantilla, puntos, presupuesto, id) {

    constructor(id: Int, nombre: String, posicion: String, presupuesto: Double) :
            this(id, nombre, presupuesto) {
        posicion
    }

    constructor(id: Int, nombre: String, puntos: Int) :
            this(id, nombre, puntos) {}

    fun jugadores(jugador: Jugador) {
        jugadores.add(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000))
        jugadores.add(Jugador(2, "Ronald Araújo", "Defensa", 4000000))
        jugadores.add(Jugador(3, "Eric García", "Defensa", 1000000))
        jugadores.add(Jugador(4, "Pedri", "Mediocentro", 5000000))
        jugadores.add(Jugador(5, "Robert Lewandowski", "Delantero", 8000000))
        jugadores.add(Jugador(6, "Courtois", "Portero", 3000000))
        jugadores.add(Jugador(7, "David Alaba", "Defensa", 4000000))
        jugadores.add(Jugador(8, "Jesús Vallejo", "Defensa", 500000))
        jugadores.add(Jugador(9, "Luka Modric", "Mediocentro", 5000000))
        jugadores.add(Jugador(10, "Karim Benzema", "Delantero", 8000000))
        jugadores.add(Jugador(11, "Ledesma", "Portero", 500000))
        jugadores.add(Jugador(12, "Juan Cala", "Defensa", 300000))
        jugadores.add(Jugador(13, "Zaldua", "Defensa", 400000))
        jugadores.add(Jugador(14, "Alez Fernández", "Mediocentro", 700000))
        jugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000))
        jugadores.add(Jugador(16, "Rajković", "Portero", 300000))
        jugadores.add(Jugador(17, "Raíllo", "Defensa", 200000))
        jugadores.add(Jugador(18, "Maffeo", "Defensa", 300000))
        jugadores.add(Jugador(19, "Ruiz de Galarreta", "Mediocentro", 400000))
        jugadores.add(Jugador("Ángel", "Delantero", 300000))
        jugadores.add(Jugador(20, "Remiro", "Portero", 1000000))
        jugadores.add(Jugador(21, "Elustondo", "Defensa", 900000))
        jugadores.add(Jugador(22, "Zubeldia", "Defensa", 800000))
        jugadores.add(Jugador(23, "Zubimendi", "Mediocentro", 1000000))
        jugadores.add(Jugador(24, "Take Kubo", "Delantero", 800000))
    }

    fun puntuaciones(jugador: Jugador) {
        puntuaciones.add(Jugador(1, "Marc-André ter Stegen", 10))
        puntuaciones.add(Jugador(2, "Ronald Araújo", 0))
        puntuaciones.add(Jugador(3, "Eric García", 3))
        puntuaciones.add(Jugador(4, "Pedri", 23))
        puntuaciones.add(Jugador(5, "Robert Lewandowski", 15))
        puntuaciones.add(Jugador(6, "Courtois", 1))
        puntuaciones.add(Jugador(7, "David Alaba", 5))
        puntuaciones.add(Jugador(8, "Jesús Vallejo", 10))
        puntuaciones.add(Jugador(9, "Luka Modric", 5))
        puntuaciones.add(Jugador(10, "Karim Benzema", 10))
        puntuaciones.add(Jugador(11, "Ledesma", 6))
        puntuaciones.add(Jugador(12, "Juan Cala", 3))
        puntuaciones.add(Jugador(13, "Zaldua", 6))
        puntuaciones.add(Jugador(14, "Alez Fernández", 9))
        puntuaciones.add(Jugador(15, "Choco Lozano", 4))
        puntuaciones.add(Jugador(16, "Rajković", 3))
        puntuaciones.add(Jugador(17, "Raíllo", 6))
        puntuaciones.add(Jugador(18, "Maffeo", 0))
        puntuaciones.add(Jugador(19, "Ruiz de Galarreta", 7))
        puntuaciones.add(Jugador("Ángel", 4))
        puntuaciones.add(Jugador(20, "Remiro", 3))
        puntuaciones.add(Jugador(21, "Elustondo", 5))
        puntuaciones.add(Jugador(22, "Zubeldia", 6))
        puntuaciones.add(Jugador(23, "Zubimendi", 7))
        puntuaciones.add(Jugador(24, "Take Kubo", 4))
    }
}