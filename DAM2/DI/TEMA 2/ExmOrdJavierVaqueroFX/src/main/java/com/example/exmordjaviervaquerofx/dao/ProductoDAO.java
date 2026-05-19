package com.example.exmordjaviervaquerofx.dao;

import com.example.exmordjaviervaquerofx.databases.DBConnection;
import com.example.exmordjaviervaquerofx.databases.SchemeDB;
import com.example.exmordjaviervaquerofx.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements IProductoDAO {

    private final Connection conexion;

    public ProductoDAO() {
        this.conexion = DBConnection.getConnection();
    }

    @Override
    public void insertarProducto(Producto producto) throws SQLException {
        if (conexion == null) {
            throw new SQLException("No hay conexion con la base de datos");
        }

        String sql = "INSERT INTO " + SchemeDB.TAB_PRODUCTOS +
                " (" + SchemeDB.COL_CODIGO + "," + SchemeDB.COL_NOMBRE + "," + SchemeDB.COL_DESCRIPCION + "," + SchemeDB.COL_PRECIO + ") " +
                "VALUES (?,?,?,?)";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, producto.getCodigo());
            sentencia.setString(2, producto.getNombre());
            sentencia.setString(3, producto.getDescripcion());
            sentencia.setDouble(4, producto.getPrecio());
            int filas = sentencia.executeUpdate();
            if (filas != 1) {
                throw new SQLException("No se pudo insertar el producto");
            }
        }
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() throws SQLException {
        if (conexion == null) {
            throw new SQLException("No hay conexion con la base de datos");
        }

        String sql = "SELECT " + SchemeDB.COL_ID + "," + SchemeDB.COL_CODIGO + "," + SchemeDB.COL_NOMBRE + "," +
                SchemeDB.COL_DESCRIPCION + "," + SchemeDB.COL_PRECIO +
                " FROM " + SchemeDB.TAB_PRODUCTOS + " ORDER BY " + SchemeDB.COL_ID + " DESC";

        List<Producto> productos = new ArrayList<>();

        try (PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet rs = sentencia.executeQuery()) {

            while (rs.next()) {
                Producto producto = Producto.builder()
                        .id(rs.getLong(SchemeDB.COL_ID))
                        .codigo(rs.getString(SchemeDB.COL_CODIGO))
                        .nombre(rs.getString(SchemeDB.COL_NOMBRE))
                        .descripcion(rs.getString(SchemeDB.COL_DESCRIPCION))
                        .precio(rs.getDouble(SchemeDB.COL_PRECIO))
                        .build();
                productos.add(producto);
            }
        }

        return productos;
    }
}