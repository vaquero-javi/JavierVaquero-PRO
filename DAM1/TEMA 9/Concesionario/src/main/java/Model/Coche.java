package Model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Coche implements Serializable {
    public static float serialVersionUID = 1L;
    private long id;
    private String marca, modelo, matricula;

    public String exportarDatos(){
        return getMarca()+","+getModelo()+","+getMatricula();
    }

    public void mostrarDatos(){
        System.out.println("marca = " + marca);
        System.out.println("modelo = " + modelo);
        System.out.println("matricula = " + matricula);
    }

    public Coche(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }
}
