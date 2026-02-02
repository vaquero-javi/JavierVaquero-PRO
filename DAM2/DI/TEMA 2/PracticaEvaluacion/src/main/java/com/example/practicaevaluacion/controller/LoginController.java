package com.example.practicaevaluacion.controller;

import com.example.practicaevaluacion.dao.UsuarioDAO;
import com.example.practicaevaluacion.dao.UsuarioDAOImpl;
import com.example.practicaevaluacion.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnLogin;

    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    @FXML
    private void login() {
        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "Formulario incompleto",
                    "Completa todos los campos.", Alert.AlertType.ERROR);
            return;
        }

        Usuario usuario = usuarioDAO.buscarPorEmailYPassword(email, password);

        if (usuario != null) {
            cargarPantallaProductos(usuario);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Usuario no encontrado");
            alert.setHeaderText("Las credenciales no son válidas");
            alert.setContentText("¿Desea registrarse con estos datos?");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    registrarNuevoUsuario(email, password);
                }
            });
        }
    }

    private void registrarNuevoUsuario(String email, String password) {
        System.out.println("INTENTANDO REGISTRAR USUARIO...");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        if (usuarioDAO.existeEmail(email)) {
            System.out.println("ERROR: El email ya existe en la base de datos");
            mostrarAlerta("Error", "Email existente",
                    "El email ya está registrado en el sistema.", Alert.AlertType.ERROR);
            return;
        }

        String nombre = email.split("@")[0];
        Usuario nuevoUsuario = new Usuario(nombre, email, password);
        System.out.println("Usuario creado: " + nuevoUsuario);

        try {
            usuarioDAO.insertarUsuario(nuevoUsuario);
            System.out.println("¡USUARIO REGISTRADO EXITOSAMENTE!");
            System.out.println("ID asignado: " + nuevoUsuario.getId());

            mostrarAlerta("Éxito", "Registro exitoso",
                    "Usuario registrado correctamente. Ahora puede iniciar sesión.",
                    Alert.AlertType.INFORMATION);
            txtPassword.clear();

        } catch (SQLException e) {
            System.err.println("ERROR SQL al registrar usuario:");
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();

            mostrarAlerta("Error", "Error en registro",
                    "Hubo un error al registrar el usuario: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        }
    }

    private void cargarPantallaProductos(Usuario usuario) {
        try {
            Stage loginStage = (Stage) btnLogin.getScene().getWindow();
            loginStage.close();

            Stage productosStage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/com/example/practicaevaluacion/productos.fxml")
            );
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);

            ProductosController controller = fxmlLoader.getController();
            controller.setUsuario(usuario);

            productosStage.setTitle("Tienda Online - " + usuario.getNombre());
            productosStage.setScene(scene);
            productosStage.show();

        } catch (IOException e) {
            mostrarAlerta("Error", "Error al cargar pantalla",
                    "No se pudo cargar la pantalla de productos.", Alert.AlertType.ERROR);
        }
    }
    private void mostrarAlerta(String titulo, String header, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}