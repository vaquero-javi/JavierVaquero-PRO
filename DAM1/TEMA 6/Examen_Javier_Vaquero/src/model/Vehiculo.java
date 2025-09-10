package model;

public class Vehiculo {
    private int serie;
    private String marca;
    private String modelo;
    private String estado;
    private int precioVenta;

    Coche coche=new Coche();

    public Vehiculo() {
    }

    public Vehiculo(int serie, String marca, String modelo, String estado, int precioVenta) {
        this.serie = serie;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.precioVenta = precioVenta;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }
}
