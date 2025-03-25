package model;

public class Bebida extends Consumiciones{
    private int mililitros;

    public Bebida() {
    }

    public Bebida(String nombre, double precio, int mililitros) {
        super(nombre, precio);
        this.mililitros = mililitros;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("mililitros = " + mililitros);
    }

    public int getMililitros() {
        return mililitros;
    }

    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }
}
