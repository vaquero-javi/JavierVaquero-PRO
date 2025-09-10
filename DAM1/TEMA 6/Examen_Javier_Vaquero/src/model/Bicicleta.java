package model;

public class Bicicleta extends Vehiculo{
    private String mtb;
    private String carretera;
    private String cross;

    public Bicicleta(){}

    public Bicicleta(int serie, String marca, String modelo, String estado, int precioVenta,
                     String mtb, String carretera, String cross) {
        super(serie, marca, modelo, estado, precioVenta);
        this.mtb = mtb;
        this.carretera = carretera;
        this.cross = cross;
    }

    public String getMtb() {
        return mtb;
    }

    public void setMtb(String mtb) {
        this.mtb = mtb;
    }

    public String getCarretera() {
        return carretera;
    }

    public void setCarretera(String carretera) {
        this.carretera = carretera;
    }

    public String getCross() {
        return cross;
    }

    public void setCross(String cross) {
        this.cross = cross;
    }
}
