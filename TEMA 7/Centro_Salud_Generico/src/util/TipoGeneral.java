package util;

public enum TipoGeneral {
    FAMILIAR, INFANTIL;

    private String nombrePaciente;
    private int edadPaciente;
    private String tipoPaciente;

    TipoGeneral() {
    }

    TipoGeneral(String nombrePaciente, int edadPaciente, String tipoPaciente) {
        this.nombrePaciente = nombrePaciente;
        this.edadPaciente = edadPaciente;
        this.tipoPaciente = tipoPaciente;
    }

    public void calcularTipoGeneral(int edadPaciente){
        if (edadPaciente >= 12){
            tipoPaciente = INFANTIL.tipoPaciente;
        }else {
            tipoPaciente = FAMILIAR.tipoPaciente;
        }
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(int edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }
}
