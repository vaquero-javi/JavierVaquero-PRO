package model;

public class Digestivo extends Doctor{
    private int aniosExperiencia;

    public Digestivo() {
    }

    public Digestivo(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("aniosExperiencia = " + aniosExperiencia);
    }

    //TODO
    public void realizarIntervencion(){

    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
}
