package model;

public class Audio extends Elemento {
    private double duracion;
    private String soporte;


    public Audio(String id, String titulo, Persona autor, int tamanio, String formato, double duracion, String soporte) {
        super(id, titulo, autor, tamanio, formato);
        this.duracion = duracion;
        this.soporte = soporte;
    }

    public Audio(){}

    public Audio(double duracion, String soporte){
        this.duracion=duracion;
        this.soporte = soporte;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("duracion = " + duracion);
        System.out.println("soporte = " + soporte);
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }
}
