package model;

public class Comida extends Consumiciones{
    private int numCalorias;

    public Comida() {
    }

    public Comida(String nombre, double precio, int numCalorias) {
        super(nombre, precio);
        this.numCalorias = numCalorias;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("numCalorias = " + numCalorias);
    }

    public int getNumCalorias() {
        return numCalorias;
    }

    public void setNumCalorias(int numCalorias) {
        this.numCalorias = numCalorias;
    }
}
