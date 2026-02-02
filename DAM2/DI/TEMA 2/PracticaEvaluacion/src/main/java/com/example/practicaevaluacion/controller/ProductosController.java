package com.example.practicaevaluacion.controller;

import com.example.practicaevaluacion.dao.ProductoDAO;
import com.example.practicaevaluacion.dao.ProductoDAOImpl;
import com.example.practicaevaluacion.dao.CompraDAO;
import com.example.practicaevaluacion.dao.CompraDAOImpl;
import com.example.practicaevaluacion.model.Producto;
import com.example.practicaevaluacion.model.Usuario;
import com.example.practicaevaluacion.model.Compra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

public class ProductosController {

    @FXML private TableView<Producto> tblProductos;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Integer> colStock;

    @FXML private Label lblUsuario;
    @FXML private Label lblTotalProductos;
    @FXML private Label lblTotalPrecio;

    @FXML private Button btnComprar;
    @FXML private Button btnVaciar;
    @FXML private Button btnVerCarrito;

    private ProductoDAO productoDAO;
    private CompraDAO compraDAO;
    private Usuario usuarioActual;
    private ObservableList<Producto> listaProductos;

    public ProductosController() {
        this.productoDAO = new ProductoDAOImpl();
        this.compraDAO = new CompraDAOImpl();
        this.listaProductos = FXCollections.observableArrayList();
    }

    @FXML
    private void initialize() {
        configurarTabla();
        cargarProductos();
    }

    private void configurarTabla() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tblProductos.setItems(listaProductos);

        colPrecio.setCellFactory(column -> new TableCell<Producto, Double>() {
            @Override
            protected void updateItem(Double precio, boolean empty) {
                super.updateItem(precio, empty);
                if (empty || precio == null) {
                    setText(null);
                } else {
                    setText(String.format("$%.2f", precio));
                }
            }
        });
    }

    private void cargarProductos() {
        List<Producto> productos = productoDAO.obtenerTodosProductos();
        listaProductos.setAll(productos);
    }

    public void setUsuario(Usuario usuario) {
        this.usuarioActual = usuario;
        if (lblUsuario != null) {
            lblUsuario.setText("Usuario: " + usuario.getNombre());
            actualizarResumenCarrito();
        }
    }

    @FXML
    private void comprar() {
        Producto productoSeleccionado = tblProductos.getSelectionModel().getSelectedItem();

        if (productoSeleccionado == null) {
            mostrarAlerta("Error", "Producto no seleccionado",
                    "Por favor, seleccione un producto de la lista.", Alert.AlertType.WARNING);
            return;
        }

        if (productoSeleccionado.getStock() <= 0) {
            mostrarAlerta("Error", "Sin stock",
                    "Este producto no tiene stock disponible.", Alert.AlertType.WARNING);
            return;
        }

        TextInputDialog dialog = new TextInputDialog("1");
        dialog.setTitle("Cantidad");
        dialog.setHeaderText("Comprar: " + productoSeleccionado.getNombre());
        dialog.setContentText("Ingrese la cantidad:");

        dialog.showAndWait().ifPresent(cantidadStr -> {
            try {
                int cantidad = Integer.parseInt(cantidadStr);

                if (cantidad <= 0) {
                    mostrarAlerta("Error", "Cantidad inválida",
                            "La cantidad debe ser mayor a 0.", Alert.AlertType.ERROR);
                    return;
                }

                if (cantidad > productoSeleccionado.getStock()) {
                    mostrarAlerta("Error", "Stock insuficiente",
                            "No hay suficiente stock. Stock disponible: " + productoSeleccionado.getStock(),
                            Alert.AlertType.ERROR);
                    return;
                }

                if (productoDAO.actualizarStock(productoSeleccionado.getId(), cantidad)) {
                    try {
                        Compra compra = new Compra(usuarioActual.getId(), productoSeleccionado.getId(), cantidad);
                        compraDAO.insertarOActualizarCompra(compra);
                        mostrarAlerta("Éxito", "Compra realizada",
                                "Producto añadido al carrito.", Alert.AlertType.INFORMATION);
                        cargarProductos();
                        actualizarResumenCarrito();
                    } catch (SQLException e) {
                        productoDAO.restaurarStock(productoSeleccionado.getId(), cantidad);
                        mostrarAlerta("Error", "Error en compra",
                                "No se pudo registrar la compra.", Alert.AlertType.ERROR);
                    }
                } else {
                    mostrarAlerta("Error", "Error en stock",
                            "No se pudo actualizar el stock.", Alert.AlertType.ERROR);
                }

            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "Cantidad inválida",
                        "Por favor, ingrese un número válido.", Alert.AlertType.ERROR);
            }
        });
    }

    @FXML
    private void vaciarCarrito() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Vaciar carrito");
        alert.setHeaderText("¿Está seguro de vaciar el carrito?");
        alert.setContentText("Esta acción no se puede deshacer.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {

                List<Producto> carrito = compraDAO.obtenerProductosPorUsuarioId(usuarioActual.getId());

                for (Producto producto : carrito) {
                    productoDAO.restaurarStock(producto.getId(), producto.getStock());
                }

                int eliminadas = compraDAO.eliminarComprasPorUsuarioId(usuarioActual.getId());
                if (eliminadas > 0) {
                    mostrarAlerta("Éxito", "Carrito vaciado",
                            "Se ha vaciado el carrito exitosamente.", Alert.AlertType.INFORMATION);
                    cargarProductos();
                    actualizarResumenCarrito();
                }
            }
        });
    }

    @FXML
    private void verCarrito() {
        List<Producto> carrito = compraDAO.obtenerProductosPorUsuarioId(usuarioActual.getId());

        if (carrito.isEmpty()) {
            mostrarAlerta("Carrito vacío", "No hay productos",
                    "El carrito está vacío.", Alert.AlertType.INFORMATION);
            return;
        }

        StringBuilder contenido = new StringBuilder();
        contenido.append("=== PRODUCTOS EN CARRITO ===\n\n");

        double total = compraDAO.calcularTotalCarrito(usuarioActual.getId());
        int totalProductos = compraDAO.obtenerCantidadTotalCarrito(usuarioActual.getId());

        for (Producto producto : carrito) {
            contenido.append(producto.getNombre())
                    .append(" - Cantidad: ").append(producto.getStock())
                    .append(" - Precio unitario: $").append(String.format("%.2f", producto.getPrecio()))
                    .append(" - Subtotal: $")
                    .append(String.format("%.2f", producto.getPrecio() * producto.getStock()))
                    .append("\n");
        }

        contenido.append("\n=== RESUMEN ===\n");
        contenido.append("Total productos: ").append(totalProductos).append("\n");
        contenido.append("Total a pagar: $").append(String.format("%.2f", total));

        TextArea textArea = new TextArea(contenido.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefSize(400, 300);

        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Carrito de compras");
        alert.setHeaderText("Productos en su carrito");
        alert.getDialogPane().setContent(scrollPane);
        alert.showAndWait();
    }

    private void actualizarResumenCarrito() {
        double total = compraDAO.calcularTotalCarrito(usuarioActual.getId());
        int totalProductos = compraDAO.obtenerCantidadTotalCarrito(usuarioActual.getId());

        lblTotalProductos.setText("Productos en carrito: " + totalProductos);
        lblTotalPrecio.setText("Total: $" + String.format("%.2f", total));
    }

    private void mostrarAlerta(String titulo, String header, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}