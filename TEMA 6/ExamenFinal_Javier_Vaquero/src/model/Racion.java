package model;

public class Racion extends Consumiciones{
    private double cantidadPlato;

    public Racion() {
    }

    public Racion(String nombre, double precio, double cantidadPlato) {
        super(nombre, precio);
        this.cantidadPlato = cantidadPlato;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("cantidadPlato = " + cantidadPlato);
    }

    public double getCantidadPlato() {
        return cantidadPlato;
    }

    public void setCantidadPlato(double cantidadPlato) {
        this.cantidadPlato = cantidadPlato;
    }
}
