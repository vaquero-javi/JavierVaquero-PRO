package com.example.calculadorafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;

public class FormController implements Initializable {

    // Todas las anotaciones @FXML al principio de la clase
    @FXML private BorderPane panelGeneral;
    @FXML private VBox panelCentral;
    @FXML private TextField pantalla;
    @FXML private ListView<String> listViewUsuarios;
    @FXML private VBox parteDerecha;
    @FXML private GridPane parteIzquierda;

    // Botones principales
    @FXML private Button botonRetroceso;
    @FXML private Button botonBorrar;
    @FXML private Button botonPorcentaje;
    @FXML private Button botonDivision;
    @FXML private Button boton7;
    @FXML private Button boton8;
    @FXML private Button boton9;
    @FXML private Button botonMultiplicacion;
    @FXML private Button boton4;
    @FXML private Button boton5;
    @FXML private Button boton6;
    @FXML private Button botonResta;
    @FXML private Button boton1;
    @FXML private Button boton2;
    @FXML private Button boton3;
    @FXML private Button botonSuma;
    @FXML private Button botonCientifica;
    @FXML private Button boton0;
    @FXML private Button botonPunto;
    @FXML private Button botonIgual;

    // Botones científicos
    @FXML private Button botonRaizCuadrada;
    @FXML private Button botonAbrirParentesis;
    @FXML private Button botonCerrarParentesis;

    // ToggleButtons y MenuItems
    @FXML private ToggleButton toggleHistorial;
    @FXML private ToggleButton toggleCientifica;
    @FXML private MenuItem menuHistorial;
    @FXML private MenuItem menuEliminar;

    // Variables para la lógica de la calculadora
    private double numero1 = 0;
    private double numero2 = 0;
    private String operacion = "";
    private String pantallaTexto = "0";
    private List<String> historial = new ArrayList<>();

    // Instancia de la clase interna
    private ManejoAcciones manejoAcciones;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        initGUI();
        acciones();
    }

    private void instancias() {
        // Inicializar la clase de manejo de acciones
        manejoAcciones = new ManejoAcciones();

        // Ocultar paneles laterales al inicio
        parteIzquierda.setVisible(false);
        parteDerecha.setVisible(false);
    }

    private void initGUI() {
        // Configurar pantalla inicial
        pantalla.setText(pantallaTexto);
        pantalla.setEditable(false);

        // Configurar ListView para historial
        listViewUsuarios.setPlaceholder(new Label("No hay operaciones en el historial"));
    }

    private void acciones() {
        // Configurar toggle buttons
        toggleHistorial.setOnAction(e -> manejoAcciones.toggleHistorial());
        toggleCientifica.setOnAction(e -> manejoAcciones.toggleCientifica());

        // Configurar menú
        menuHistorial.setOnAction(e -> manejoAcciones.mostrarHistorial());
        menuEliminar.setOnAction(e -> manejoAcciones.eliminarHistorial());

        // Botones numéricos
        boton0.setOnAction(e -> manejoAcciones.agregarNumero("0"));
        boton1.setOnAction(e -> manejoAcciones.agregarNumero("1"));
        boton2.setOnAction(e -> manejoAcciones.agregarNumero("2"));
        boton3.setOnAction(e -> manejoAcciones.agregarNumero("3"));
        boton4.setOnAction(e -> manejoAcciones.agregarNumero("4"));
        boton5.setOnAction(e -> manejoAcciones.agregarNumero("5"));
        boton6.setOnAction(e -> manejoAcciones.agregarNumero("6"));
        boton7.setOnAction(e -> manejoAcciones.agregarNumero("7"));
        boton8.setOnAction(e -> manejoAcciones.agregarNumero("8"));
        boton9.setOnAction(e -> manejoAcciones.agregarNumero("9"));

        // Operaciones básicas
        botonSuma.setOnAction(e -> manejoAcciones.prepararOperacion("+"));
        botonResta.setOnAction(e -> manejoAcciones.prepararOperacion("-"));
        botonMultiplicacion.setOnAction(e -> manejoAcciones.prepararOperacion("×"));
        botonDivision.setOnAction(e -> manejoAcciones.prepararOperacion("/"));
        botonIgual.setOnAction(e -> manejoAcciones.calcularResultado());

        // Botones especiales
        botonPunto.setOnAction(e -> manejoAcciones.agregarPunto());
        botonBorrar.setOnAction(e -> manejoAcciones.limpiarTodo());
        botonRetroceso.setOnAction(e -> manejoAcciones.borrarUltimo());
        botonPorcentaje.setOnAction(e -> manejoAcciones.calcularPorcentaje());

        // Botones científicos
        botonRaizCuadrada.setOnAction(e -> manejoAcciones.funcionCientifica("raiz"));
        botonAbrirParentesis.setOnAction(e -> manejoAcciones.agregarNumero("("));
        botonCerrarParentesis.setOnAction(e -> manejoAcciones.agregarNumero(")"));
        botonCientifica.setOnAction(e -> manejoAcciones.mostrarFuncionesCientificas());
    }

    // CLASE INTERNA ManejoAcciones
    public class ManejoAcciones {

        // Métodos para números y operaciones básicas
        public void agregarNumero(String numero) {
            if (pantallaTexto.equals("0") || pantallaTexto.equals("Error")) {
                pantallaTexto = numero;
            } else {
                pantallaTexto += numero;
            }
            pantalla.setText(pantallaTexto);
        }

        public void prepararOperacion(String op) {
            if (!pantallaTexto.equals("Error")) {
                try {
                    numero1 = Double.parseDouble(pantallaTexto);
                    operacion = op;
                    pantallaTexto = "0";
                    pantalla.setText(pantallaTexto);
                } catch (Exception e) {
                    pantallaTexto = "Error";
                    pantalla.setText(pantallaTexto);
                }
            }
        }

        public void calcularResultado() {
            if (!pantallaTexto.equals("Error") && !operacion.isEmpty()) {
                try {
                    numero2 = Double.parseDouble(pantallaTexto);
                    double resultado = 0;

                    switch (operacion) {
                        case "+":
                            resultado = numero1 + numero2;
                            break;
                        case "-":
                            resultado = numero1 - numero2;
                            break;
                        case "×":
                            resultado = numero1 * numero2;
                            break;
                        case "/":
                            if (numero2 != 0) {
                                resultado = numero1 / numero2;
                            } else {
                                throw new ArithmeticException("División por cero");
                            }
                            break;
                    }

                    String operacionCompleta = numero1 + " " + operacion + " " + numero2 + " = " + resultado;
                    pantallaTexto = String.valueOf(resultado);
                    pantalla.setText(pantallaTexto);
                    agregarAlHistorial(operacionCompleta);
                    operacion = "";

                } catch (Exception e) {
                    pantallaTexto = "Error";
                    pantalla.setText(pantallaTexto);
                }
            }
        }

        public void agregarPunto() {
            if (!pantallaTexto.contains(".")) {
                pantallaTexto += ".";
                pantalla.setText(pantallaTexto);
            }
        }

        public void limpiarTodo() {
            pantallaTexto = "0";
            pantalla.setText(pantallaTexto);
            numero1 = 0;
            numero2 = 0;
            operacion = "";
        }

        public void borrarUltimo() {
            if (pantallaTexto.length() > 1) {
                pantallaTexto = pantallaTexto.substring(0, pantallaTexto.length() - 1);
            } else {
                pantallaTexto = "0";
            }
            pantalla.setText(pantallaTexto);
        }

        public void calcularPorcentaje() {
            if (!pantallaTexto.equals("Error")) {
                try {
                    double numero = Double.parseDouble(pantallaTexto);
                    double porcentaje = numero / 100;
                    pantallaTexto = String.valueOf(porcentaje);
                    pantalla.setText(pantallaTexto);
                    agregarAlHistorial(numero + "% = " + porcentaje);
                } catch (Exception e) {
                    pantallaTexto = "Error";
                    pantalla.setText(pantallaTexto);
                }
            }
        }

        // Métodos para funciones científicas
        public void funcionCientifica(String funcion) {
            if (!pantallaTexto.equals("Error")) {
                try {
                    double numero = Double.parseDouble(pantallaTexto);
                    double resultado = 0;

                    switch (funcion) {
                        case "raiz":
                            if (numero >= 0) {
                                resultado = Math.sqrt(numero);
                                agregarAlHistorial("√" + numero + " = " + resultado);
                            } else {
                                throw new ArithmeticException("Raíz de número negativo");
                            }
                            break;
                    }

                    pantallaTexto = String.valueOf(resultado);
                    pantalla.setText(pantallaTexto);

                } catch (Exception e) {
                    pantallaTexto = "Error";
                    pantalla.setText(pantallaTexto);
                }
            }
        }

        public void mostrarFuncionesCientificas() {
            // Podría mostrar un diálogo con más funciones
            agregarAlHistorial("Acceso a funciones científicas");
        }

        // Métodos para los toggle buttons
        public void toggleHistorial() {
            if (toggleHistorial.isSelected()) {
                parteIzquierda.setVisible(true);
                actualizarHistorial();
            } else {
                parteIzquierda.setVisible(false);
            }
        }

        public void toggleCientifica() {
            if (toggleCientifica.isSelected()) {
                parteDerecha.setVisible(true);
            } else {
                parteDerecha.setVisible(false);
            }
        }

        // Métodos para el menú
        public void mostrarHistorial() {
            toggleHistorial.setSelected(true);
            toggleHistorial();
        }

        public void eliminarHistorial() {
            historial.clear();
            actualizarHistorial();
        }

        // Métodos auxiliares
        private void agregarAlHistorial(String operacion) {
            historial.add(0, operacion); // Agregar al principio
            if (historial.size() > 10) {
                historial.remove(historial.size() - 1); // Mantener solo 10 elementos
            }
            actualizarHistorial();
        }

        private void actualizarHistorial() {
            listViewUsuarios.getItems().setAll(historial);
        }
    }
}