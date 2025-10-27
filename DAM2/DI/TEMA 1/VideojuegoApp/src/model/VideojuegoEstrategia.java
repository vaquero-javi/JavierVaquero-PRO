package model;

public class VideojuegoEstrategia extends Videojuego{

    private int complejidad, duracionPartida;

    public VideojuegoEstrategia() {
    }

    public VideojuegoEstrategia(String titulo, String desarrollador, String clasificacionEdad, int id,
                                int anioLanzamiento, double precio, double tamanioJuego, int complejidad,
                                int duracionPartida) {
        super(titulo, desarrollador, clasificacionEdad, id, anioLanzamiento, precio, tamanioJuego);
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
        }else {
            System.out.println("Solo hay 5 niveles de complejidad");
        }
        return getPrecio();
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
