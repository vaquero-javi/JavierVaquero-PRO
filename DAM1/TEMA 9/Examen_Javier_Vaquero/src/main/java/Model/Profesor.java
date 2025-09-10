package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Connection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Profesor implements Serializable {
    public static float serialVersionUID = 1L;
    private long id;
    String nombre;
    String dni;
    double salarioBaseAnual;

    public Profesor(String nombre, String dni, double salarioBaseAnual) {
        this.nombre = nombre;
        this.dni = dni;
        this.salarioBaseAnual = salarioBaseAnual;
    }

    public void mostrarDatos() {
        System.out.println("nombre = " + nombre);
        System.out.println("dni = " + dni);
        System.out.println("dni = " + dni);
        System.out.println("salarioBaseAnual = " + salarioBaseAnual);
    }
}
