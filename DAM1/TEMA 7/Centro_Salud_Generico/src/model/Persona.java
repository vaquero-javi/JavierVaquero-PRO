package model;

public class Persona {
    private String nombre;
    private String apellidos;

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("apellidos = " + apellidos);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
