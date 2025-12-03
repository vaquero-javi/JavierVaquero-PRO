package com.example.loginappfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloController {

    @FXML
    private Label statusLabel;

    public void initialize() {

        Thread serverThread = new Thread(() -> {
            try {
                ServerSocket server = new ServerSocket(6000);
                System.out.println("Servidor TCP escuchando en puerto 6000...");

                while (true) {
                    Socket client = server.accept();

                    ObjectInputStream ois =
                            new ObjectInputStream(client.getInputStream());

                    Login login = (Login) ois.readObject();

                    javafx.application.Platform.runLater(() ->
                            statusLabel.setText(
                                    "Usuario: " + login.user +
                                            " | Contraseña: " + login.pass
                            )
                    );

                    client.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        serverThread.setDaemon(true);
        serverThread.start();
    }
}
