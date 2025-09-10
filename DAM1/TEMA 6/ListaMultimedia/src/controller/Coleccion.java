package controller;

import model.Elemento;
import model.Libro;

import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Elemento> elementos;

    public Coleccion(){
        elementos = new ArrayList<>();
    }

    public Coleccion(ArrayList<Elemento>elementos){
        this.elementos=elementos;
    }

    public void anadirElemento(Elemento item){
        elementos.add(item);
    }

    public void eliminarElemento (String id){
        for (Elemento elemento : elementos){
            if (elemento.getId().equalsIgnoreCase(id)){
                elementos.remove(elemento);
            }
        }
    }

    public void listarElemento(int tipo){
        for (Elemento item : elementos){
            switch (tipo){
                case 0:
                    if (item instanceof Libro){
                        
                    }
            }
        }

    }


}
