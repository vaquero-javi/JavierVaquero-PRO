package util;

public enum Proveedor {

    //tipos predefinidos
    Mahou("Cerveza Mahou",5,"Juan Gomez"),
    Cocacola("Bebida gaseosa",10,"Jualia Martinez"),
    ComidaSL,
    BebidasSL("Bebidas generales",0,"Maria Gomez");

    //variables
    private String nombre;
    private int descuento;
    private String contacto;

    //constructores
    Proveedor(){}

    Proveedor(String nombre, String contacto, int descuento) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.descuento = descuento;
    }

    //metodos
    public String getNombre() {
        return nombre;
    }

    public int getDescuento() {
        return descuento;
    }

    public String getContacto() {
        return contacto;
    }
}
