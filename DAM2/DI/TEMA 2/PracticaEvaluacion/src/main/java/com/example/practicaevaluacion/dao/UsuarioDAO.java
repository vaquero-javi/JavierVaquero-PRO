package com.example.practicaevaluacion.dao;

import com.example.practicaevaluacion.model.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    void insertarUsuario(Usuario usuario) throws SQLException;
    Usuario buscarPorEmailYPassword(String email, String password);
    Usuario buscarPorEmail(String email);
    List<Usuario> obtenerTodosUsuarios();
    int eliminarUsuarioPorEmail(String email);
    boolean existeEmail(String email);
}
