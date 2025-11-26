package com.example.examenjaviervaquero.controller;

import com.example.examenjaviervaquero.dao.UsuarioDAO;
import com.example.examenjaviervaquero.dao.UsuarioDAOImp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;



public class FormController implements Initializable {
    @FXML
    private TextField correo;
    @FXML
    private Button login;
    @FXML
    private GridPane panelPrincipal;
    @FXML
    private TextField passw;

    private UsuarioDAOImp usuarioDAOImp;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        login.setOnAction(new ManejoActions());

    }

    private void initGUI() {

    }

    private void instancias() {
        usuarioDAO = new UsuarioDAOImp();
    }

    class ManejoActions implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == login) {

                if (!correo.getText().isEmpty() && !passw.getText().isEmpty()) {
                    String mail = correo.getText();
                    String contraseña = passw.getText();
                }


            }


        }
    }
}
