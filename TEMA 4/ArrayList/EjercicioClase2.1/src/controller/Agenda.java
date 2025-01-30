package controller;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Object[]> listaContactos;

    //constructor primario
    public Agenda() {
        listaContactos = new ArrayList<>();
    }

    public boolean agregarPersona(String nombre, String apellido, int telefono, String dni) {
        Object[] contacto = new Object[]{nombre, apellido, telefono, dni};

        if (!estaPersona(dni)) {
            listaContactos.add(contacto);
            return true;
        }
        return false;

    }

    private Object[] estaPersona(String dni) {
        for (Object[] contacto : listaContactos) {
            if (String.valueOf(contacto[3]).equalsIgnoreCase(dni)) {
                //esta en la lista
                return contacto;
            }
        }
        //no esta en la lista
        return null;

    }

    public int listarDatosPersona(String dni) {
        Object[] usuario = estaPersona(dni);
        if (listaContactos.isEmpty()) {
            //la lista esta vacia
            return 1;
        } else if (usuario == null) {
            //la lista no está vacía pero el usuario no esta
            return 2;
        }
        //la lista no está vacía pero el usuario no esta
        for (Object item : usuario){
            System.out.println(item);
        }
        return 3;


    }

}
