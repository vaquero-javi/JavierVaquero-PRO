package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Carrera {
    static Scanner scanner = new Scanner(System.in);

    private int vueltas;
    private String nombreCarrera;
    private Coche ganador;
    private ArrayList<Coche> participantes;

    public Carrera(int vueltas, String nombreCarrera) {
        this.vueltas = vueltas;
        this.nombreCarrera = nombreCarrera;
    }

    public void mostrarClasificacion() {
        for (Coche coche : participantes) {
            int posicion = 1;
            for (Coche coche : participantes) {
                System.out.println(posicion + "-" + coche.getMarca() + "-" + coche.getModelo());
                posicion++;
            }
        }
    }

    public void inscribirParticipantes(Coche coche) {
        if (participantes.size()==8 || coche.getCv() >= 300 || coche.getMatricula() == matricula){
            System.out.println("Lo siento, no puedes inscribir");
        }else {
            participantes.add(coche);
            System.out.println("Agregado correctamente");
        }
    }


    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public ArrayList<Coche> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Coche> participantes) {
        this.participantes = participantes;
    }

    public Coche getGanador() {
        return ganador;
    }

    public void setGanador(Coche ganador) {
        this.ganador = ganador;
    }
}
