package model;

public class Doctor extends Persona{
    private String numColegiado;



    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("numColegiado = " + numColegiado);
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }
}
