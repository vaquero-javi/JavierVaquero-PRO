package com.example.exmordjaviervaquerofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("productos-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Gestion de productos");
        stage.setScene(scene);
        stage.setMinWidth(520);
        stage.setMinHeight(520);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}