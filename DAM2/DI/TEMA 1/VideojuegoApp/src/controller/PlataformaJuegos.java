package controller;

import model.Videojuego;

import java.util.ArrayList;
import java.util.Comparator;

public class PlataformaJuegos {
    private ArrayList<Videojuego> listavideojuegos;


    public void aniadirVideojuego(Videojuego videojuego) {
        listavideojuegos.add(videojuego);
    }

    public Videojuego estaVideojuego(int id) {
        for (Videojuego item : listavideojuegos) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void eliminarVideojuego(int id) {
        if (estaVideojuego(id) == null) {
            System.out.println("No está el videojuego");
        } else {
            listavideojuegos.remove(estaVideojuego(id));
        }
    }

    public void juegosOrdenadosMenorMAyor() {
        listavideojuegos.sort(new Comparator<Videojuego>() {
            @Override
            public int compare(Videojuego o1, Videojuego o2) {
                if (o1.calcularPrecioFinal() > o2.calcularPrecioFinal()) {
                    return -1;
                } else if (o1.calcularPrecioFinal() < o2.calcularPrecioFinal()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void filtarjuegosXEdad(String edad) {
        for (Videojuego item : listavideojuegos) {
            if (item.getClasificacionEdad().equals(edad)) {
                System.out.println(item);
            }
        }
    }

    public void precioTotalJuegos(){
        double contadorPrecio = 0.0;
        for (Videojuego item : listavideojuegos){
            contadorPrecio += item.calcularPrecioFinal();
        }
    }

}
