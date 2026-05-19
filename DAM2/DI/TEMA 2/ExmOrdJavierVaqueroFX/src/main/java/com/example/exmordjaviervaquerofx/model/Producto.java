package com.example.exmordjaviervaquerofx.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precio;
}