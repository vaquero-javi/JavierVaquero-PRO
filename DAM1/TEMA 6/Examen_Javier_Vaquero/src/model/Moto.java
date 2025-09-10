package model;

public class Moto extends Vehiculo{
    private String transmision;
    private double peso;

    public Moto() {
    }

    public Moto(int serie, String marca, String modelo, String estado, int precioVenta, String transmision, double peso) {
        super(serie, marca, modelo, estado, precioVenta);
        this.transmision = transmision;
        this.peso = peso;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
