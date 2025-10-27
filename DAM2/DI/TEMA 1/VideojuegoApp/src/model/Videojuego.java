package model;

abstract public class Videojuego {
    private String titulo, desarrollador, clasificacionEdad;
    private int id, anioLanzamiento;
    private double precio, tamanioJuego;

    public Videojuego() {
    }

    public Videojuego(String titulo, String desarrollador, String clasificacionEdad, int id, int anioLanzamiento,
                      double precio, double tamanioJuego) {
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.clasificacionEdad = clasificacionEdad;
        this.id = id;
        this.anioLanzamiento = anioLanzamiento;
        this.precio = precio;
        this.tamanioJuego = tamanioJuego;
    }

    abstract public double calcularPrecioFinal();

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", clasificacionEdad='" + clasificacionEdad + '\'' +
                ", id=" + id +
                ", anioLanzamiento=" + anioLanzamiento +
                ", precio=" + precio +
                ", tamanioJuego=" + tamanioJuego +
                '}';
    }

    public double getTamanioJuego() {
        return tamanioJuego;
    }

    public void setTamanioJuego(double tamanioJuego) {
        this.tamanioJuego = tamanioJuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
