package model;

public class Triangulo {
    private int base;
    private int altura;

    public Triangulo(){}

    public void area(int base, int altura){
        this.base = base;
        this.altura = altura;

        int area = base * altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
