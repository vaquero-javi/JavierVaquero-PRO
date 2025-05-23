package model;

public class Persona {
    private String nombre;
    private String dni;

    public Persona(){}

    public Persona(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    public void mostrarDatos(){
        System.out.println("El nombre es "+nombre);
        System.out.println("El dni es "+dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
