package model;

public class ArmaBiologica extends Armas{
    private String descripcion;

    public ArmaBiologica() {
    }

    public ArmaBiologica(int idArmas, int nivelPotencia, int nivelDaño, String nombreArmas, String descripcion) {
        super(idArmas, nivelPotencia, nivelDaño, nombreArmas);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
