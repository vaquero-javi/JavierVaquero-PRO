package com.example.examenjaviervaquero.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Producto {
    String nombre,categoria;
    int precio;
}
