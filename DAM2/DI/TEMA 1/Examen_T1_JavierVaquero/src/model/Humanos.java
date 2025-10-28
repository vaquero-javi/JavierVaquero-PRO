package model;

public class Humanos extends Superheroe{
    private int resistencia;
    private ArmaTradicional armaTradicional;

    public Humanos() {
    }

    public Humanos(int id, int nivel, int nivelSuperheroe,String nombre, Armas armas,int resistencia, ArmaTradicional armaTradicional) {
        super(id, nivel, nivelSuperheroe,nombre, armas);
        this.resistencia = resistencia;
        this.armaTradicional = armaTradicional;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public ArmaTradicional getArmaTradicional() {
        return armaTradicional;
    }

    public void setArmaTradicional(ArmaTradicional armaTradicional) {
        this.armaTradicional = armaTradicional;
    }
}
