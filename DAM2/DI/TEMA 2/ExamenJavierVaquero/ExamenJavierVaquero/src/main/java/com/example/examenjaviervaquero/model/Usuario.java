package com.example.examenjaviervaquero.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private String nombre, correo, contraseña;

    @Override
    public String toString() {
        return nombre;
    }
}
