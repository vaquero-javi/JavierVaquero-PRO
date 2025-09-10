package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Usuario {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor


    private String nombre, correo, pass;
    private int perfil, ventas;

    public Usuario(String nombre, String correo, String pass, int perfil, int ventas) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.perfil = perfil;
        this.ventas = ventas;
    }
}
