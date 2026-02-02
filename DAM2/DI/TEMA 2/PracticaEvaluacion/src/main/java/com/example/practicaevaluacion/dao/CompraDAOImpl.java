package com.example.practicaevaluacion.dao;

import com.example.practicaevaluacion.database.DBConnection;
import com.example.practicaevaluacion.database.SchemeDB;
import com.example.practicaevaluacion.model.Compra;
import com.example.practicaevaluacion.model.Producto;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompraDAOImpl implements CompraDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public CompraDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void insertarOActualizarCompra(Compra compra) throws SQLException {
        String query = String.format("""
            INSERT INTO %s.%s (%s, %s, %s) 
            VALUES (?, ?, ?)
            ON DUPLICATE KEY UPDATE %s = %s + VALUES(%s)
            """, SchemeDB.DB_NAME, SchemeDB.TAB_COMPRAS,
                SchemeDB.COL_COMPRA_USUARIO_ID,
                SchemeDB.COL_COMPRA_PRODUCTO_ID,
                SchemeDB.COL_COMPRA_CANTIDAD,
                SchemeDB.COL_COMPRA_CANTIDAD, SchemeDB.COL_COMPRA_CANTIDAD,
                SchemeDB.COL_COMPRA_CANTIDAD);

        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, compra.getUsuarioId());
        preparedStatement.setInt(2, compra.getProductoId());
        preparedStatement.setInt(3, compra.getCantidad());

        preparedStatement.executeUpdate();

        // Obtener el ID generado
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                compra.setId(generatedKeys.getInt(1));
            }
        }
    }

    @Override
    public List<Producto> obtenerProductosPorUsuarioId(int usuarioId) {
        List<Producto> lista = new ArrayList<>();
        String query = String.format("""
            SELECT p.*, c.%s 
            FROM %s.%s p
            JOIN %s.%s c ON p.%s = c.%s
            WHERE c.%s = ?
            """, SchemeDB.COL_COMPRA_CANTIDAD,
                SchemeDB.DB_NAME, SchemeDB.TAB_PRODUCTOS,
                SchemeDB.DB_NAME, SchemeDB.TAB_COMPRAS,
                SchemeDB.COL_PRODUCTO_ID, SchemeDB.COL_COMPRA_PRODUCTO_ID,
                SchemeDB.COL_COMPRA_USUARIO_ID);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuarioId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Producto producto = new Producto(
                        resultSet.getInt(SchemeDB.COL_PRODUCTO_ID),
                        resultSet.getString(SchemeDB.COL_PRODUCTO_NOMBRE),
                        resultSet.getString(SchemeDB.COL_PRODUCTO_DESCRIPCION),
                        resultSet.getDouble(SchemeDB.COL_PRODUCTO_PRECIO),
                        resultSet.getInt(SchemeDB.COL_COMPRA_CANTIDAD)
                );
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de obtener productos por usuario");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Compra> obtenerComprasPorUsuarioId(int usuarioId) {
        List<Compra> lista = new ArrayList<>();
        String query = String.format("SELECT * FROM %s.%s WHERE %s = ? ORDER BY %s DESC",
                SchemeDB.DB_NAME, SchemeDB.TAB_COMPRAS,
                SchemeDB.COL_COMPRA_USUARIO_ID,
                SchemeDB.COL_COMPRA_FECHA);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuarioId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Compra compra = new Compra(
                        resultSet.getInt(SchemeDB.COL_COMPRA_ID),
                        resultSet.getInt(SchemeDB.COL_COMPRA_USUARIO_ID),
                        resultSet.getInt(SchemeDB.COL_COMPRA_PRODUCTO_ID),
                        resultSet.getInt(SchemeDB.COL_COMPRA_CANTIDAD),
                        resultSet.getTimestamp(SchemeDB.COL_COMPRA_FECHA).toLocalDateTime()
                );
                lista.add(compra);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de obtener compras por usuario");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public int eliminarComprasPorUsuarioId(int usuarioId) {
        int filasAfectadas = 0;
        String query = String.format("DELETE FROM %s.%s WHERE %s = ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_COMPRAS,
                SchemeDB.COL_COMPRA_USUARIO_ID);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuarioId);
            filasAfectadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la query de eliminar compras");
            System.out.println(e.getMessage());
        }
        return filasAfectadas;
    }

    @Override
    public int eliminarCompraPorUsuarioYProducto(int usuarioId, int productoId) {
        int filasAfectadas = 0;
        String query = String.format("DELETE FROM %s.%s WHERE %s = ? AND %s = ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_COMPRAS,
                SchemeDB.COL_COMPRA_USUARIO_ID,
                SchemeDB.COL_COMPRA_PRODUCTO_ID);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuarioId);
            preparedStatement.setInt(2, productoId);
            filasAfectadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la query de eliminar compra específica");
            System.out.println(e.getMessage());
        }
        return filasAfectadas;
    }

    @Override
    public double calcularTotalCarrito(int usuarioId) {
        double total = 0.0;
        String query = String.format("""
            SELECT SUM(p.%s * c.%s) as total
            FROM %s.%s p
            JOIN %s.%s c ON p.%s = c.%s
            WHERE c.%s = ?
            """, SchemeDB.COL_PRODUCTO_PRECIO,
                SchemeDB.COL_COMPRA_CANTIDAD,
                SchemeDB.DB_NAME, SchemeDB.TAB_PRODUCTOS,
                SchemeDB.DB_NAME, SchemeDB.TAB_COMPRAS,
                SchemeDB.COL_PRODUCTO_ID, SchemeDB.COL_COMPRA_PRODUCTO_ID,
                SchemeDB.COL_COMPRA_USUARIO_ID);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuarioId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de calcular total del carrito");
            System.out.println(e.getMessage());
        }
        return total;
    }

    @Override
    public int obtenerCantidadTotalCarrito(int usuarioId) {
        int cantidadTotal = 0;
        String query = String.format("SELECT SUM(%s) as total FROM %s.%s WHERE %s = ?",
                SchemeDB.COL_COMPRA_CANTIDAD,
                SchemeDB.DB_NAME, SchemeDB.TAB_COMPRAS,
                SchemeDB.COL_COMPRA_USUARIO_ID);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuarioId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cantidadTotal = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de obtener cantidad total del carrito");
            System.out.println(e.getMessage());
        }
        return cantidadTotal;
    }
}