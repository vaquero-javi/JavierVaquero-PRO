package model;

public class VideojuegoAccion extends Videojuego implements Descargable{
    private int nivelDeViolencia;
    private boolean modoMultijugador;

    public VideojuegoAccion() {
    }

    public VideojuegoAccion(String titulo, String desarrollador, String clasificacionEdad, int id,
                            int anioLanzamiento, double precio, double tamanioJuego, int nivelDeViolencia,
                            boolean modoMultijugador) {
        super(titulo, desarrollador, clasificacionEdad, id, anioLanzamiento, precio, tamanioJuego);
        this.nivelDeViolencia = nivelDeViolencia;
        this.modoMultijugador = modoMultijugador;
    }

    @Override
    public double calcularPrecioFinal() {
        if (nivelDeViolencia>3){
            setPrecio(getPrecio() + getPrecio()*0.05);
        }
        if (modoMultijugador){
            setPrecio(getPrecio() + getPrecio()*0.1);
        }
        return getPrecio();
    }

    @Override
    public int calcularTiempoDeDescarga(double velocidadInternet) {
        return (int) (velocidadInternet * 0.5);
    }

    @Override
    public double tamanioGB() {
        return getTamanioJuego();
    }

    public boolean isModoMultijugador() {
        return modoMultijugador;
    }

    public void setModoMultijugador(boolean modoMultijugador) {
        this.modoMultijugador = modoMultijugador;
    }

    public int getNivelDeViolencia() {
        return nivelDeViolencia;
    }

    public void setNivelDeViolencia(int nivelDeViolencia) {
        this.nivelDeViolencia = nivelDeViolencia;
    }
}
