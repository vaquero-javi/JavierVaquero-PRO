package model;

public class Paciente extends Persona{
    private String numSS;
    private String dolencia;

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("numSS = " + numSS);
        System.out.println("dolencia = " + dolencia);
    }

    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public String getDolencia() {
        return dolencia;
    }

    public void setDolencia(String dolencia) {
        this.dolencia = dolencia;
    }
}
