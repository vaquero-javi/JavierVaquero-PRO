package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Productos implements Serializable {
    public static float serialVersionUID = 1L;
    private long id;
    private String nombre;
    private double precio;
    private int cantidad;

    public Productos(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    private String exportarDatos(){

    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("precio = " + precio);
        System.out.println("cantidad = " + cantidad);
    }


}
