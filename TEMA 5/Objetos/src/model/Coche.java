package model;

import java.util.ArrayList;

public class Coche {

    //propiedades
    private String marca, modelo, color, matricula, bastidor;
    private double precio;
    private int cv, par, km;



    //contructores -> por defecto tengo el constructor vacio sin escribir nada
    //ALT+INSERT+CONSTRUCTOR
    public Coche(){
        //sirve para inicializar el objeto y por ende todos los atributos de este
        matricula="sin definir";
        modelo="sin definir";
        marca="sin definir";
        bastidor="sin definir";
        color="sin definir";

    }

    public Coche(String marca, String modelo, String matricula, int cv) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
    }
    public Coche(String bastidor, String matricula, String marca, String modelo) {
        this.bastidor = bastidor;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Coche(String marca, String modelo, String color){
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;
    }

    public Coche(String marca, String modelo, int cv){
        this.marca=marca;
        this.modelo=modelo;
        this.cv=cv;
        this.par=(int) Math.pow(cv*2,2);
    }

    public Coche(String marca, String modelo, String color,String bastidor,String matricula, int cv, int precio ){
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;
        this.bastidor=bastidor;
        this.matricula=matricula;
        this.cv=cv;
        this.par=(int) Math.pow(cv*2,2);
        this.precio= precio*0.85;
    }



    //metodos
    public void mostrarDatos(){
        System.out.println("La marca es: "+marca);
        System.out.println("El modelo es: "+modelo);
        System.out.println("Los cv son: "+cv);
        System.out.println("El par es: "+par);
        System.out.println("El color es "+color);
        System.out.println("El numero de bastidor es: "+bastidor);
        System.out.println("La matricula es: "+matricula);
        System.out.println("El precio es "+precio);
    }




    //metodos especiales
    //ALT+INSERT+GETTER/SETTER

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km += km;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){

        this.marca=marca;
    }

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public String getMatricula() {

        return matricula;
    }

    public void setMatricula(String matricula) {

        this.matricula = matricula;
    }

    public String getBastidor() {

        return bastidor;
    }

    public void setBastidor(String bastidor) {

        this.bastidor = bastidor;
    }

    public double getPrecio() {

        return precio;
    }

    public void setPrecio(double precio) {

        this.precio = precio;
    }

    public int getCv() {

        return cv;
    }

    public void setCv(int cv) {

        this.cv = cv;
    }

    public int getPar() {

        return par;
    }

    public void setPar(int par) {

        this.par = par;
    }
}
