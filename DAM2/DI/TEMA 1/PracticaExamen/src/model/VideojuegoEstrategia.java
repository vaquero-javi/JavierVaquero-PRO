package model;

public class VideojuegoEstrategia extends Videojuego implements Descargable{
    private int complejidad, duracionPartida;

    public VideojuegoEstrategia() {
    }

    public VideojuegoEstrategia(int id, String titulo, String desarrollador, String clasificacionEdad, int anioLanzamiento,
                                double precio, double tamanioGB ,int complejidad, int duracionPartida) {
        super(id, titulo, desarrollador, clasificacionEdad, anioLanzamiento, precio, tamanioGB);
        this.complejidad = complejidad;
        this.duracionPartida = duracionPartida;
    }

    @Override
    public double calcularPrecioFinal() {
        if (complejidad == 1){
            setPrecio(getPrecio() + getPrecio()*0.03);
        } else if (complejidad == 2) {
            setPrecio(getPrecio() + getPrecio()*0.06);
        } else if (complejidad == 3) {
            setPrecio(getPrecio() + getPrecio()*0.09);
        } else if (complejidad == 4) {
            setPrecio(getPrecio() + getPrecio()*0.12);
        } else if (complejidad == 5) {
            setPrecio(getPrecio() + getPrecio()*0.15);
        }
        return getPrecio();
    }

    @Override
    public int calcularTiempoDescarga(double velocidadInternet) {
        return (int) velocidadInternet;
    }

    @Override
    public double obtenerTamanioGB() {
        return getTamanioGB();
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public int getDuracionPartida() {
        return duracionPartida;
    }

    public void setDuracionPartida(int duracionPartida) {
        this.duracionPartida = duracionPartida;
    }
}
