package controller;

import java.util.Hashtable;

public class Garaje {
    Hashtable<String, Object[]> listaCoches;

    public Garaje(){
        listaCoches=new Hashtable<>();
    }

    public void agregarCoche (String matricula, String marca, String modelo, int precio, int cv){
        Object[] nuevoCoche = listaCoches.put(listaCoches[matricula,marca,modelo,precio,cv]);
    }
    
}
