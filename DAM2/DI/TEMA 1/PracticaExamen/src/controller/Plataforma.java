package controller;

import model.Videojuego;
import model.VideojuegoAccion;

import java.util.ArrayList;
import java.util.Comparator;

public class Plataforma {

    ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

    public void aniadirJuegos(Videojuego videojuego){
        listaVideojuegos.add(videojuego);
        System.out.println("Juego añadido");
    }

    public void eliminarJuegos(int id){
       if (estaVideojuego(id) == null){
           System.out.println("El juego no esta en la plataforma");
       }else {
           listaVideojuegos.remove(estaVideojuego(id));
           System.out.println("Juego eliminado");
       }
    }

    public Videojuego estaVideojuego(int id){
        for (Videojuego item : listaVideojuegos){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public void ordenarXPrecio(){
        listaVideojuegos.sort(new Comparator<Videojuego>() {
            @Override
            public int compare(Videojuego o1, Videojuego o2) {
                if (o1.calcularPrecioFinal() > o2.calcularPrecioFinal()){
                    return -1;
                } else if (o1.calcularPrecioFinal() < o2.calcularPrecioFinal()) {
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println(listaVideojuegos);
    }

    public void ordenarXEdad(String edad){
        for (Videojuego item : listaVideojuegos){
             if (item.getClasificacionEdad().equals(edad)){
                System.out.println(item);
             }
        }
    }

    public void precioTotal(){
        double precioTot=0.0;
        for (Videojuego item : listaVideojuegos){
            precioTot += item.calcularPrecioFinal();
        }
        System.out.println("El precio total es " + precioTot);
    }
}
