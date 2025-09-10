package model;

public class Patinete extends Vehiculo{
    private int autonomia;

    public Patinete(){}

    public Patinete(int serie, String marca, String modelo, String estado, int precioVenta, int autonomia) {
        super(serie, marca, modelo, estado, precioVenta);
        this.autonomia = autonomia;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }
}
