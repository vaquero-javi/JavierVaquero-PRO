package model;

public class VideojuegoRPG extends Videojuego implements Descargable{
    private boolean mundoAbierto;
    private int horasHistoriaPartida;

    public VideojuegoRPG() {
    }

    public VideojuegoRPG(int id, String titulo, String desarrollador, String clasificacionEdad, int anioLanzamiento,
                         double precio, double tamanioGB ,boolean mundoAbierto, int horasHistoriaPartida) {
        super(id, titulo, desarrollador, clasificacionEdad, anioLanzamiento, precio, tamanioGB);
        this.mundoAbierto = mundoAbierto;
        this.horasHistoriaPartida = horasHistoriaPartida;
    }

    @Override
    public double calcularPrecioFinal() {
        if (mundoAbierto){
            setPrecio(getPrecio() + getPrecio()*0.15);
        }
        double contador = 0.02 * (double) horasHistoriaPartida / 10;
        setPrecio(getPrecio() + getPrecio()*contador);
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

    public boolean isMundoAbierto() {
        return mundoAbierto;
    }

    public void setMundoAbierto(boolean mundoAbierto) {
        this.mundoAbierto = mundoAbierto;
    }

    public int getHorasHistoriaPartida() {
        return horasHistoriaPartida;
    }

    public void setHorasHistoriaPartida(int horasHistoriaPartida) {
        this.horasHistoriaPartida = horasHistoriaPartida;
    }
}
