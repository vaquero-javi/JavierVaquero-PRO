package controller;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Object[]> listaContactos;

    //constructor primario
    public Agenda(){
        listaContactos = new ArrayList<>();
    }
    public void agregarPersona (String nombre, String apellido, int telefono, String dni){
        Object[] contacto = new Object[]{nombre, apellido, telefono, dni};
        System.out.println("Introduce un nombre, apellido, telefono y dni");

        if (!estaPersona(dni)){
            listaContactos.add(contacto);
            System.out.println("Contacto añadido correctamente");
        }else {
            System.out.println("Error, este contacto ya está en la lista");
        }

    }
    private  boolean estaPersona (String dni){
        for (Object[] contacto : listaContactos){
            if (String.valueOf(contacto[3]).equals(dni)){
                return true;
            }
        }
        return false;
    }
}
