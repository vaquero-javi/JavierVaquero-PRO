package model;

public class Mutantes extends Superheroe{
    private ArmaBiologica armaBiologica;

    public Mutantes() {
    }

    public Mutantes(int id, int nivel, int nivelSuperheroe,String nombre, Armas armas,ArmaBiologica armaBiologica) {
        super(id, nivel, nivelSuperheroe,nombre, armas);
        this.armaBiologica = armaBiologica;
    }

    public ArmaBiologica getArmaBiologica() {
        return armaBiologica;
    }

    public void setArmaBiologica(ArmaBiologica armaBiologica) {
        this.armaBiologica = armaBiologica;
    }
}
