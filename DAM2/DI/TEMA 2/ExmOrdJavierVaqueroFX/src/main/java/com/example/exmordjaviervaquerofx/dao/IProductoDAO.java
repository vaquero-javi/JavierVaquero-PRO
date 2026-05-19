package com.example.exmordjaviervaquerofx.dao;

import com.example.exmordjaviervaquerofx.model.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoDAO {
    void insertarProducto(Producto producto) throws SQLException;
    List<Producto> obtenerTodosLosProductos() throws SQLException;
}