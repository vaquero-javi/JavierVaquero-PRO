package model;

abstract public class Superheroe {
    private int id, nivel, nivelSuperheroe;
    private String nombre;
    private Armas armas;

    public Superheroe() {
    }

    public Superheroe(int id, int nivel, int nivelSuperheroe,String nombre, Armas armas) {
        this.id = id;
        this.nivel = nivel;
        this.nombre = nombre;
        this.nivelSuperheroe = nivelSuperheroe;
        this.armas = armas;
    }

    public Armas getArmas() {
        return armas;
    }

    public void setArmas(Armas armas) {
        this.armas = armas;
    }

    public int getNivelSuperheroe() {
        return nivelSuperheroe;
    }

    public void setNivelSuperheroe(int nivelSuperheroe) {
        this.nivelSuperheroe = nivelSuperheroe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
