package model;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private ArrayList<Consumiciones>listaConsumiciones;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String dni, ArrayList<Consumiciones> listaConsumiciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.listaConsumiciones = listaConsumiciones;
    }

    public void mostrarDatosCliente(){
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("dni = " + dni);
        System.out.println("listaConsumiciones = " + listaConsumiciones);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Consumiciones> getListaConsumiciones() {
        return listaConsumiciones;
    }

    public void setListaConsumiciones(ArrayList<Consumiciones> listaConsumiciones) {
        this.listaConsumiciones = listaConsumiciones;
    }
}
