package com.example.exmordjaviervaquerofx.controller;

import com.example.exmordjaviervaquerofx.dao.IProductoDAO;
import com.example.exmordjaviervaquerofx.dao.ProductoDAO;
import com.example.exmordjaviervaquerofx.model.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class ProductosController {

    @FXML
    private TextField campoNombre;

    @FXML
    private TextArea campoDescripcion;

    @FXML
    private TextField campoPrecio;

    @FXML
    private TextField campoCodigo;

    private final IProductoDAO productoDAO = new ProductoDAO();

    @FXML
    private void agregarProducto() {
        String nombre = campoNombre.getText() == null ? "" : campoNombre.getText().trim();
        String codigo = campoCodigo.getText() == null ? "" : campoCodigo.getText().trim();
        String descripcion = campoDescripcion.getText() == null ? "" : campoDescripcion.getText().trim();
        String precioTexto = campoPrecio.getText() == null ? "" : campoPrecio.getText().trim();

        String error = validarDatos(nombre, codigo, precioTexto);
        if (error != null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Validacion", error);
            return;
        }

        Double precio = Double.parseDouble(precioTexto);

        Producto producto = Producto.builder()
                .nombre(nombre)
                .codigo(codigo)
                .descripcion(descripcion)
                .precio(precio)
                .build();

        try {
            productoDAO.insertarProducto(producto);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Producto guardado", "Producto agregado correctamente");
            limpiarFormulario();
        } catch (SQLException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de base de datos", e.getMessage());
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Algo está fallando: " + e.getMessage());
        }
    }

    @FXML
    private void abrirLista() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("com/example/exmordjaviervaquerofx/lista-view.fxml"));
            Parent raiz = loader.load();

            Stage ventana = new Stage();
            ventana.setTitle("Lista de productos");
            ventana.initModality(Modality.NONE);
            ventana.setScene(new Scene(raiz));
            ventana.setMinWidth(420);
            ventana.setMinHeight(420);
            ventana.show();
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo abrir la pantalla de lista: " + e.getMessage());
        }
    }

    private String validarDatos(String nombre, String codigo, String precioTexto) {
        if (nombre.isEmpty()){
            return "El nombre es obligatorio";
        }
        if (codigo.isEmpty()){
            return "El codigo es obligatorio";
        }
        if (precioTexto.isEmpty()){
            return "El precio es obligatorio";
        }

        return null;
    }

    private void limpiarFormulario() {
        campoNombre.clear();
        campoCodigo.clear();
        campoDescripcion.clear();
        campoPrecio.clear();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
    }
}