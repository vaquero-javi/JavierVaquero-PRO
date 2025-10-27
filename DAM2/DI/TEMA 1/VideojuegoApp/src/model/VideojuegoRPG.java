package model;

public class VideojuegoRPG extends Videojuego{

    private boolean mundoAbierto;
    private int horasHistorialPrincipal;

    public VideojuegoRPG() {
    }

    public VideojuegoRPG(String titulo, String desarrollador, String clasificacionEdad, int id,
                         int anioLanzamiento, double precio, double tamanioJuego, boolean mundoAbierto,
                         int horasHistorialPrincipal) {
        super(titulo, desarrollador, clasificacionEdad, id, anioLanzamiento, precio, tamanioJuego);
        this.mundoAbierto = mundoAbierto;
        this.horasHistorialPrincipal = horasHistorialPrincipal;
    }

    @Override
    public double calcularPrecioFinal() {
        if (mundoAbierto){
            setPrecio(getPrecio() + getPrecio()*0.15);
        }
        double incrementar = 0.02 * (double)horasHistorialPrincipal/10;
        setPrecio(getPrecio() + getPrecio()*incrementar);

        return getPrecio();
    }

    public boolean isMundoAbierto() {
        return mundoAbierto;
    }

    public void setMundoAbierto(boolean mundoAbierto) {
        this.mundoAbierto = mundoAbierto;
    }

    public int getHorasHistorialPrincipal() {
        return horasHistorialPrincipal;
    }

    public void setHorasHistorialPrincipal(int horasHistorialPrincipal) {
        this.horasHistorialPrincipal = horasHistorialPrincipal;
    }
}
