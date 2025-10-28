package model;

public class VideojuegoAccion extends Videojuego implements Descargable{
    private int nivelViolencia;
    private boolean modoMultijugador;

    public VideojuegoAccion() {
    }

    public VideojuegoAccion(int id, String titulo, String desarrollador, String clasificacionEdad, int anioLanzamiento,
                            double precio,double tamanioGB, int nivelViolencia, boolean modoMultijugador) {
        super(id, titulo, desarrollador, clasificacionEdad, anioLanzamiento, precio, tamanioGB);
        this.nivelViolencia = nivelViolencia;
        this.modoMultijugador = modoMultijugador;
    }

    @Override
    public double calcularPrecioFinal() {
        if (nivelViolencia >3){
            setPrecio(getPrecio() + getPrecio()*0.03);
        }
        if (modoMultijugador){
            setPrecio(getPrecio() + getPrecio()*0.1);
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

    public int getNivelViolencia() {
        return nivelViolencia;
    }

    public void setNivelViolencia(int nivelViolencia) {
        this.nivelViolencia = nivelViolencia;
    }

    public boolean getModoMultijugador() {
        return modoMultijugador;
    }

    public void setModoMultijugador(boolean modoMultijugador) {
        this.modoMultijugador = modoMultijugador;
    }
}
