package model;

public class Tienda {
    private int nuevo;
    private int seminuevo;
    private int usado;
    private int roto;

    public Tienda() {
    }

    public Tienda(int nuevo, int seminuevo, int usado, int roto) {
        this.nuevo = nuevo;
        this.seminuevo = seminuevo;
        this.usado = usado;
        this.roto = roto;
    }

    public reparacion (int precio){
        nuevo = (int) (precio*0.9);
        seminuevo= (int) (precio*0.95);
        usado =(int) (precio);
    }

    public int getNuevo() {
        return nuevo;
    }

    public void setNuevo(int nuevo) {
        this.nuevo = nuevo;
    }

    public int getSeminuevo() {
        return seminuevo;
    }

    public void setSeminuevo(int seminuevo) {
        this.seminuevo = seminuevo;
    }

    public int getUsado() {
        return usado;
    }

    public void setUsado(int usado) {
        this.usado = usado;
    }

    public int getRoto() {
        return roto;
    }

    public void setRoto(int roto) {
        this.roto = roto;
    }
}
