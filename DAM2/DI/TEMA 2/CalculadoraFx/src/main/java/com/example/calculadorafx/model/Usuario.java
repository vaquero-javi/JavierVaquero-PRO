package com.example.calculadorafx.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Usuario {
    private int operando1, operando2, simboloOperando, retroceso, resultado;

    @Override
    public String toString() {
        return String.valueOf(resultado);
    }
}
