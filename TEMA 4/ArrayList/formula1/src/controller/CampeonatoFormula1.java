package controller;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CampeonatoFormula1 {
    public Hashtable<String, Piloto> campeonato = new Hashtable<>();
    public ArrayList<Integer> puntosPosibles = new ArrayList<>();
    private final int MaxPilotos = 10;
    private final int MaxCarreras = 7;
    private int carrerasRestantes = MaxCarreras;

    public CampeonatoFormula1() {
        inicializarPuntosPosibles();
    }

    private void inicializarPuntosPosibles() {
        for (int i = 1; i <= 12; i++) {
            puntosPosibles.add(i);
        }
    }

    public boolean agregarPiloto(String nombre, String bastidor) {
        if (campeonato.size() >= MaxPilotos) {
            System.out.println("No se pueden agregar más pilotos. Límite alcanzado.");
            return false;
        }

        if (campeonato.containsKey(bastidor)) {
            System.out.println("Error: Ya existe un piloto con este bastidor.");
            return false;
        }

        Piloto piloto = new Piloto(nombre, bastidor, 0);
        campeonato.put(bastidor, piloto);
        System.out.println("Piloto agregado exitosamente.");
        return true;
    }

    public void actualizarPuntosCarrera() {
        if (campeonato.size() < MaxPilotos) {
            System.out.println("Error: No hay suficientes pilotos para realizar una carrera.");
            return;
        }

        if (carrerasRestantes <= 0) {
            System.out.println("No quedan carreras por correr.");
            return;
        }

        Collections.shuffle(puntosPosibles);
        ArrayList<String> clavesPilotos = new ArrayList<>(campeonato.keySet());

        for (int i = 0; i < clavesPilotos.size(); i++) {
            Piloto piloto = campeonato.get(clavesPilotos.get(i));
            int puntosCarrera = puntosPosibles.get(i);
            piloto.agregarPuntos(puntosCarrera);
        }

        carrerasRestantes--;
        System.out.println("Puntos distribuidos en esta carrera. Carreras restantes: " + carrerasRestantes);
    }

    public void mostrarInformacionPiloto(String bastidor) {
        if (campeonato.containsKey(bastidor)) {
            Piloto piloto = campeonato.get(bastidor);
            System.out.println(piloto);
        } else {
            System.out.println("Error: No se encontró un piloto");
        }
    }

    public void mostrarClasificacion() {
        ArrayList<Piloto> pilotosOrdenados = new ArrayList<>(campeonato.values());
        pilotosOrdenados.sort(Comparator.comparingInt(Piloto::getPuntos).reversed());

        System.out.println("Clasificación actual:");
        for (Piloto piloto : pilotosOrdenados) {
            System.out.println(piloto);
        }
    }

    public int getCarrerasRestantes() {

        return carrerasRestantes;
    }
}

