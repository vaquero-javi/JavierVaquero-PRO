package model;

public class Coche extends Vehiculo{

    private int cv;
    private int cc;

    public Coche() {
    }

    public Coche(int serie, String marca, String modelo, String estado, int precioVenta, int cv, int cc) {
        super(serie, marca, modelo, estado, precioVenta);
        this.cv = cv;
        this.cc = cc;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
}
