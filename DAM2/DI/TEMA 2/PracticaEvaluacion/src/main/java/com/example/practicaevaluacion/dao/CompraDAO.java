package com.example.practicaevaluacion.dao;

import com.example.practicaevaluacion.model.Compra;
import com.example.practicaevaluacion.model.Producto;
import java.sql.SQLException;
import java.util.List;

public interface CompraDAO {

    void insertarOActualizarCompra(Compra compra) throws SQLException;
    List<Producto> obtenerProductosPorUsuarioId(int usuarioId);
    List<Compra> obtenerComprasPorUsuarioId(int usuarioId);
    int eliminarComprasPorUsuarioId(int usuarioId);
    int eliminarCompraPorUsuarioYProducto(int usuarioId, int productoId);
    double calcularTotalCarrito(int usuarioId);
    int obtenerCantidadTotalCarrito(int usuarioId);
}