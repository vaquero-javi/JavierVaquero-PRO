package com.example.calculadorafx.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private Button boton0;

    @FXML
    private Button boton1;

    @FXML
    private Button boton2;

    @FXML
    private Button boton3;

    @FXML
    private Button boton4;

    @FXML
    private Button boton5;

    @FXML
    private Button boton6;

    @FXML
    private Button boton7;

    @FXML
    private Button boton8;

    @FXML
    private Button boton9;

    @FXML
    private Button botonAbrirParentesis;

    @FXML
    private Button botonBorrar;

    @FXML
    private Button botonCerrarParentesis;

    @FXML
    private Button botonCientifica;

    @FXML
    private Button botonDivision;

    @FXML
    private Button botonIgual;

    @FXML
    private Button botonMultiplicacion;

    @FXML
    private Button botonPorcentaje;

    @FXML
    private Button botonPunto;

    @FXML
    private Button botonRaizCuadrada;

    @FXML
    private Button botonResta;

    @FXML
    private Button botonRetroceso;

    @FXML
    private Button botonSuma;

    @FXML
    private ListView<?> listViewUsuarios;

    @FXML
    private MenuItem menuEliminar;

    @FXML
    private MenuItem menuHistorial;

    @FXML
    private TextField pantalla;

    @FXML
    private GridPane parteIzquierda;

    @FXML
    private ToggleButton toggleCientifica;

    @FXML
    private ToggleButton toggleHistorial;

    @FXML
    private BorderPane panelGeneral;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instanciass();
        initGUI();
        acciones();
    }

    //para crear objetos, listas(arraylist), objetos de DAO
    //configurar comboBox y listView
    //configurar estilos y css
    private void instanciass() {

    }

    //logica de la parte gráfica (configurar la interfaz)
    private void initGUI() {

    }

    //logica de la aplicacion
    private void acciones() {

    }

    class ManejoAcciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

        }
    }
}

