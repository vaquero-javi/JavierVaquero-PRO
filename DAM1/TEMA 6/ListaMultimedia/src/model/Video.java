package model;

import java.util.ArrayList;

public class Video extends Elemento {
    private Persona director;
    private ArrayList<Persona> actores;

    public Video(String id, String titulo, Persona autor, int tamanio, String formato, Persona director, ArrayList<Persona> actores) {
        super(id, titulo, autor, tamanio, formato);
        this.director = director;
        this.actores = actores;
    }

    public Video (){
        actores= new ArrayList<>();
    }

    public Video(Persona director, ArrayList<Persona> actores){
        this.director = director;
        this.actores =  actores;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
    }

    public Persona getDirector() {
        return director;
    }

    public void setDirector(Persona director) {
        this.director = director;
    }

    public ArrayList<Persona> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Persona> actores) {
        this.actores = actores;
    }
}
