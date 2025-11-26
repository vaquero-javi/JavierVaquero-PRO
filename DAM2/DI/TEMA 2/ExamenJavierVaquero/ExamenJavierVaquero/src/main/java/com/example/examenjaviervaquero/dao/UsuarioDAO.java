package com.example.examenjaviervaquero.dao;

import com.example.examenjaviervaquero.model.Producto;
import com.example.examenjaviervaquero.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    void insertarUsuario(Usuario usuario)  throws SQLException;
    List<Usuario> obtenerUsuarios();
    List<Usuario> obtenerUsuarios(String correo);
    int borrarUsuarios(String nombre);

    void insertarProducto(Producto producto) throws SQLException;
    List<Producto> obtenerProductos();
    int borrarProductos(String nombre);



}
