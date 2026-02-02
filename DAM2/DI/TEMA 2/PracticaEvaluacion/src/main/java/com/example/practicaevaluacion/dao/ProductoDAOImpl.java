package com.example.practicaevaluacion.dao;

import com.example.practicaevaluacion.database.DBConnection;
import com.example.practicaevaluacion.database.SchemeDB;
import com.example.practicaevaluacion.model.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public ProductoDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void insertarProducto(Producto producto) throws SQLException {
        String query = String.format("INSERT INTO %s.%s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)",
                SchemeDB.DB_NAME, SchemeDB.TAB_PRODUCTOS,
                SchemeDB.COL_PRODUCTO_NOMBRE,
                SchemeDB.COL_PRODUCTO_DESCRIPCION,
                SchemeDB.COL_PRODUCTO_PRECIO,
                SchemeDB.COL_PRODUCTO_STOCK);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, producto.getNombre());
        preparedStatement.setString(2, producto.getDescripcion());
        preparedStatement.setDouble(3, producto.getPrecio());
        preparedStatement.setInt(4, producto.getStock());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        List<Producto> lista = new ArrayList<>();
        String query = String.format("SELECT * FROM %s.%s ORDER BY %s",
                SchemeDB.DB_NAME, SchemeDB.TAB_PRODUCTOS,
                SchemeDB.COL_PRODUCTO_NOMBRE);

        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                lista.add(mapearResultSetAProducto(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de obtener todos los productos");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Producto buscarPorId(int id) {
        Producto producto = null;
        String query = String.format("SELECT * FROM %s.%s WHERE %s = ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_PRODUCTOS,
                SchemeDB.COL_PRODUCTO_ID);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                producto = mapearResultSetAProducto(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de búsqueda por ID");
            System.out.println(e.getMessage());
        }
        return producto;
    }

    @Override
    public boolean actualizarStock(int id, int cantidad) {
        String query = String.format("UPDATE %s.%s SET %s = %s - ? WHERE %s = ? AND %s >= ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_PRODUCTOS,
                SchemeDB.COL_PRODUCTO_STOCK, SchemeDB.COL_PRODUCTO_STOCK,
                SchemeDB.COL_PRODUCTO_ID,
                SchemeDB.COL_PRODUCTO_STOCK);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cantidad);
            preparedStatement.setInt(2, id);
            preparedStatement.setInt(3, cantidad);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error en la query de actualizar stock");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean restaurarStock(int id, int cantidad) {
        String query = String.format("UPDATE %s.%s SET %s = %s + ? WHERE %s = ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_PRODUCTOS,
                SchemeDB.COL_PRODUCTO_STOCK, SchemeDB.COL_PRODUCTO_STOCK,
                SchemeDB.COL_PRODUCTO_ID);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cantidad);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error en la query de restaurar stock");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public int eliminarProductoPorId(int id) {
        int filasAfectadas = 0;
        String query = String.format("DELETE FROM %s.%s WHERE %s = ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_PRODUCTOS,
                SchemeDB.COL_PRODUCTO_ID);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            filasAfectadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la query de eliminar producto");
            System.out.println(e.getMessage());
        }
        return filasAfectadas;
    }

    private Producto mapearResultSetAProducto(ResultSet resultSet) throws SQLException {
        return new Producto(
                resultSet.getInt(SchemeDB.COL_PRODUCTO_ID),
                resultSet.getString(SchemeDB.COL_PRODUCTO_NOMBRE),
                resultSet.getString(SchemeDB.COL_PRODUCTO_DESCRIPCION),
                resultSet.getDouble(SchemeDB.COL_PRODUCTO_PRECIO),
                resultSet.getInt(SchemeDB.COL_PRODUCTO_STOCK)
        );
    }
}