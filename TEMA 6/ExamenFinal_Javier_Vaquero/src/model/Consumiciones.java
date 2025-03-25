package model;

public class Consumiciones {
    private String nombre;
    private double precio;

    public Consumiciones() {
    }

    public Consumiciones(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("precio = " + precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
