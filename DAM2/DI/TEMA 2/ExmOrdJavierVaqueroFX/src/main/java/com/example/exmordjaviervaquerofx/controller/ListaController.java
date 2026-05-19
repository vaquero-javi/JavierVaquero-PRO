package com.example.exmordjaviervaquerofx.controller;

import com.example.exmordjaviervaquerofx.dao.IProductoDAO;
import com.example.exmordjaviervaquerofx.dao.ProductoDAO;
import com.example.exmordjaviervaquerofx.model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.List;

public class ListaController {

    @FXML
    private ListView<String> listaProductos;

    private final IProductoDAO productoDAO = new ProductoDAO();

    @FXML
    private void initialize() {
        cargarProductos();
    }

    private void cargarProductos() {
        try {
            List<Producto> productos = productoDAO.obtenerTodosLosProductos();
            listaProductos.getItems().clear();
            for (Producto producto : productos) {
                if (producto.getNombre() != null) {
                    listaProductos.getItems().add(producto.getNombre());
                }
            }
        } catch (SQLException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de base de datos", e.getMessage());
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Algo está fallando...: " + e.getMessage());
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
    }
}