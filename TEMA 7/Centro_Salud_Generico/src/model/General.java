package model;

import util.TipoGeneral;

public class General extends Doctor{
    private TipoGeneral tipoGeneral;
    private Paciente paciente;
    private boolean pastillas;

    public General() {
    }

    public General(TipoGeneral tipoGeneral, Paciente paciente, boolean pastillas) {
        this.tipoGeneral = tipoGeneral;
        this.paciente = paciente;
        this.pastillas = pastillas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("tipoGeneral = " + tipoGeneral);
        System.out.println("paciente = " + paciente);
        System.out.println("paciente = " + paciente);
    }

    public void informacionTipoGeneral(){
        if (tipoGeneral == null){
            System.out.println("El tipo general no tiene nada asociado");
        }else {
            System.out.println("La información del tipo general es: ");
            System.out.println(tipoGeneral.getNombrePaciente());
            System.out.println(tipoGeneral.getEdadPaciente());
            System.out.println(tipoGeneral.getTipoPaciente());
        }
    }

    public void recetarPastillas(){
        if (paciente == null){
            System.out.println("¿Se le recetan las pastillas al cliente?");
            pastillas = false;
        }else {
            System.out.println("¿Se le recetan las pastillas al cliente?");
            pastillas = true;
        }
    }

    public TipoGeneral getTipoGeneral() {
        return tipoGeneral;
    }

    public void setTipoGeneral(TipoGeneral tipoGeneral) {
        this.tipoGeneral = tipoGeneral;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean isPastillas() {
        return pastillas;
    }

    public void setPastillas(boolean pastillas) {
        this.pastillas = pastillas;
    }
}
