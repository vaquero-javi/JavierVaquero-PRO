package com.example.practicaevaluacion.dao;

import com.example.practicaevaluacion.model.Producto;
import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {

    void insertarProducto(Producto producto) throws SQLException;
    List<Producto> obtenerTodosProductos();
    Producto buscarPorId(int id);
    boolean actualizarStock(int id, int cantidad);
    boolean restaurarStock(int id, int cantidad);
    int eliminarProductoPorId(int id);
}