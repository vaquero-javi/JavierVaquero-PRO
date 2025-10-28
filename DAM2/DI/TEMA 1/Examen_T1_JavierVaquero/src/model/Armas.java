package model;

public class Armas {
    private int idArmas, nivelPotencia, nivelDaño;
    private String nombreArmas;


    public Armas() {
    }

    public Armas(int idArmas, int nivelPotencia, int nivelDaño, String nombreArmas) {
        this.idArmas = idArmas;
        this.nivelPotencia = nivelPotencia;
        this.nivelDaño = nivelDaño;
        this.nombreArmas = nombreArmas;
    }

    public int getIdArmas() {
        return idArmas;
    }

    public void setIdArmas(int idArmas) {
        this.idArmas = idArmas;
    }

    public int getNivelPotencia() {
        return nivelPotencia;
    }

    public void setNivelPotencia(int nivelPotencia) {
        this.nivelPotencia = nivelPotencia;
    }

    public int getNivelDaño() {
        return nivelDaño;
    }

    public void setNivelDaño(int nivelDaño) {
        this.nivelDaño = nivelDaño;
    }

    public String getNombreArmas() {
        return nombreArmas;
    }

    public void setNombreArmas(String nombreArmas) {
        this.nombreArmas = nombreArmas;
    }
}
