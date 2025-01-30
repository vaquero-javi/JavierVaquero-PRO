package model;

public class Circulo {
    private double radio;
    private double diametro;
    private double area;

    public Circulo(){}

    public void area (double diametro){
        this.diametro = diametro;
        double radio = diametro/2;
        area = Math.PI * radio;
    }

    public void diametro (double radio){
        diametro = radio * 2;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getDiametro() {
        return diametro;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
