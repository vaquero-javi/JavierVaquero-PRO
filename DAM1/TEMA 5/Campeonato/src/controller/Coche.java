package controller;

public class Coche {

    private String marca, modelo, matricula;
    private int km, cv;

    public Coche(){
        marca="sin definir";
        modelo="sin definir";
        matricula="sin definir";
    }
    public Coche(String marca,String modelo, String matricula, int cv){
        this.marca= marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
    }



    public int getKm() {
        return km;
    }

    public int getCv() {
        return cv;
    }

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
