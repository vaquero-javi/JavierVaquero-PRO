package model;

public class Coche {
    private Motor motor;
    private String marca;
    private String modelo;
    private double precioAverias;
    private String matricula;

    public Coche(){}

    public Coche(String marca, String modelo, String matricula){
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public Coche(String marca, String modelo, String matricula, Motor motor){
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.motor = motor;
    }

    public void acumularAverias (double precioAverias){
        this.precioAverias = precioAverias;
        precioAverias+=(Math.random()*401)+100;
        System.out.println("El precio de la averia es "+precioAverias);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioAverias() {
        return precioAverias;
    }

    public void setPrecioAverias(double precioAverias) {
        this.precioAverias = precioAverias;
    }
}
