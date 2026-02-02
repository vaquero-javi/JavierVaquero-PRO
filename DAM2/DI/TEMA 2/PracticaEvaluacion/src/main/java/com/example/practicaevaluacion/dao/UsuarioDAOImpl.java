package com.example.practicaevaluacion.dao;

import com.example.practicaevaluacion.database.DBConnection;
import com.example.practicaevaluacion.database.SchemeDB;
import com.example.practicaevaluacion.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UsuarioDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void insertarUsuario(Usuario usuario) throws SQLException {
        String query = String.format("INSERT INTO %s.%s (%s, %s, %s) VALUES (?, ?, ?)",
                SchemeDB.DB_NAME, SchemeDB.TAB_USUARIOS,
                SchemeDB.COL_USUARIO_NOMBRE,
                SchemeDB.COL_USUARIO_EMAIL,
                SchemeDB.COL_USUARIO_PASSWORD);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setString(3, usuario.getPassword());

        preparedStatement.executeUpdate();
    }

    @Override
    public Usuario buscarPorEmailYPassword(String email, String password) {
        Usuario usuario = null;
        String query = String.format("SELECT * FROM %s.%s WHERE %s = ? AND %s = ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_USUARIOS,
                SchemeDB.COL_USUARIO_EMAIL,
                SchemeDB.COL_USUARIO_PASSWORD);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usuario = mapearResultSetAUsuario(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de búsqueda por email y password");
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        Usuario usuario = null;
        String query = String.format("SELECT * FROM %s.%s WHERE %s = ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_USUARIOS,
                SchemeDB.COL_USUARIO_EMAIL);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usuario = mapearResultSetAUsuario(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de búsqueda por email");
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String query = String.format("SELECT * FROM %s.%s ORDER BY %s",
                SchemeDB.DB_NAME, SchemeDB.TAB_USUARIOS,
                SchemeDB.COL_USUARIO_NOMBRE);

        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                lista.add(mapearResultSetAUsuario(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de obtener todos los usuarios");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public int eliminarUsuarioPorEmail(String email) {
        int filasAfectadas = 0;
        String query = String.format("DELETE FROM %s.%s WHERE %s = ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_USUARIOS,
                SchemeDB.COL_USUARIO_EMAIL);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            filasAfectadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la query de eliminar usuario");
            System.out.println(e.getMessage());
        }
        return filasAfectadas;
    }

    @Override
    public boolean existeEmail(String email) {
        String query = String.format("SELECT COUNT(*) FROM %s.%s WHERE %s = ?",
                SchemeDB.DB_NAME, SchemeDB.TAB_USUARIOS,
                SchemeDB.COL_USUARIO_EMAIL);

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error en la query de verificar email");
            System.out.println(e.getMessage());
        }
        return false;
    }

    private Usuario mapearResultSetAUsuario(ResultSet resultSet) throws SQLException {
        return new Usuario(
                resultSet.getInt(SchemeDB.COL_USUARIO_ID),
                resultSet.getString(SchemeDB.COL_USUARIO_NOMBRE),
                resultSet.getString(SchemeDB.COL_USUARIO_EMAIL),
                resultSet.getString(SchemeDB.COL_USUARIO_PASSWORD)
        );
    }
}