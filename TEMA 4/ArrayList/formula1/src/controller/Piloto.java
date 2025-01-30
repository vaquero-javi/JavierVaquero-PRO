package controller;

public class Piloto {
    private String nombre;
    private String bastidor;
    private int puntos;

    public Piloto(String nombre, String bastidor, int puntos) {
        this.nombre = nombre;
        this.bastidor = bastidor;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBastidor() {
        return bastidor;
    }

    public int getPuntos() {
        return puntos;
    }

    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Bastidor: " + bastidor + ", Puntos: " + puntos;
    }
}