package model;

public class Garaje {
    private Coche coche;
    private String averia;
    private int vehiculos=0;

    public Garaje() {
    }

    public boolean aceptarCoche(Coche coche, String averia) {
        if (this.coche == null) {
            this.coche = coche;
            this.averia = averia;
            System.out.println("El vehiculo ha sido aceptado con exito");
            int vehiculosAtendidos=0;
            vehiculosAtendidos++;
            return true;
        }
        System.out.println("El vehiculo no puede ser aceptado en este momento");
        return false;
    }

    public void devolverCoche(Coche coche,int vehiculos) {
        if (this.coche == null) {
            System.out.println("No hay vehiculos a devolver");
        } else {
            vehiculos--;
        }

    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public String getAveria() {
        return averia;
    }

    public void setAveria(String averia) {
        this.averia = averia;
    }

    public int getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(int vehiculos) {
        this.vehiculos = vehiculos;
    }
}
