package com.example.calculadorafx.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Usuario {
    private double operando1, operando2 ,resultado;
    private String simboloOperando, textoEnPantalla;

    @Override
    public String toString() {
        return String.valueOf(resultado);
    }
}
