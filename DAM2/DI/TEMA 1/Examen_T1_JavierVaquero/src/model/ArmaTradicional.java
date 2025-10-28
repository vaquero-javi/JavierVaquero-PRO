package model;

public class ArmaTradicional extends Armas{
    double pesoArma;

    public ArmaTradicional() {
    }

    public ArmaTradicional(int idArmas, int nivelPotencia, int nivelDaño, String nombreArmas, double pesoArma) {
        super(idArmas, nivelPotencia, nivelDaño, nombreArmas);
        this.pesoArma = pesoArma;
    }

    public double getPesoArma() {
        return pesoArma;
    }

    public void setPesoArma(double pesoArma) {
        this.pesoArma = pesoArma;
    }
}
