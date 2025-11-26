package com.example.examenjaviervaquero.dao;

import com.example.examenjaviervaquero.databases.DBConnection;
import com.example.examenjaviervaquero.databases.SchemeDB;
import com.example.examenjaviervaquero.model.Producto;
import com.example.examenjaviervaquero.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO{

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UsuarioDAOImp() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void insertarUsuario(Usuario usuario) throws SQLException{

        String query = String.format("INSERT INTO %s (%s,%s,%s,) VALUES (?,?,?)",
                SchemeDB.TAB_NAME,
                SchemeDB.COL_NAME, SchemeDB.COL_MAIL, SchemeDB.COL_PASS);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getCorreo());
        preparedStatement.setString(3, usuario.getContraseña());

        preparedStatement.execute();


    }

    @Override
    public List<Usuario> obtenerUsuarios() {

        List<Usuario> lista = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM "+SchemeDB.TAB_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nombre = resultSet.getString(SchemeDB.COL_NAME);
                String mail =resultSet.getString(SchemeDB.COL_MAIL);
                String contraseña = resultSet.getString(SchemeDB.COL_PASS);
                Usuario usuario = new Usuario(nombre,mail,contraseña);
                lista.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Usuario> obtenerUsuarios(String correo) {
        //obtener usuarios por correo
        List<Usuario> lista = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM %s WHERE %s = ?", SchemeDB.TAB_NAME, SchemeDB.COL_MAIL);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, correo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nombre = resultSet.getString(SchemeDB.COL_NAME);
                String mail =resultSet.getString(SchemeDB.COL_MAIL);
                String contraseña = resultSet.getString(SchemeDB.COL_PASS);
                Usuario usuario = new Usuario(nombre,mail,contraseña);
                lista.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public int borrarUsuarios(String correo) {
        int filasAfectadas = 0;
        try {
            String query = String.format("DELETE FROM %s WHERE %s = ?", SchemeDB.TAB_NAME, SchemeDB.COL_MAIL);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, correo);
            filasAfectadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la query de borrado");
            System.out.println(e.getMessage());
        }
        return filasAfectadas;

    }

    public void insertarProducto(Producto producto) throws SQLException {

        String query = String.format("INSERT INTO %s (%s,%s,%s,) VALUES (?,?,?)",
                SchemeDB.TAB_NAME,
                SchemeDB.COL_PROD_NOMBRE, SchemeDB.COL_CAT, SchemeDB.COL_PRECIO);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, producto.getNombre());
        preparedStatement.setString(2, producto.getCategoria());
        preparedStatement.setInt(3, producto.getPrecio());

        preparedStatement.execute();
    }

    public List<Producto> obtenerProductos() {
        List<Producto> lista = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM "+SchemeDB.TAB_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nombre = resultSet.getString(SchemeDB.COL_PROD_NOMBRE);
                String categoria =resultSet.getString(SchemeDB.COL_CAT);
                int precio = resultSet.getInt(SchemeDB.COL_PRECIO);
                Producto producto = new Producto(nombre,categoria,precio);
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public int borrarProductos(String nombre) {
        int filasAfectadas = 0;
        try {
            String query = String.format("DELETE FROM %s WHERE %s = ?", SchemeDB.TAB_NAME, SchemeDB.COL_PROD_NOMBRE);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            filasAfectadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la query de borrado");
            System.out.println(e.getMessage());
        }
        return filasAfectadas;
    }
}


