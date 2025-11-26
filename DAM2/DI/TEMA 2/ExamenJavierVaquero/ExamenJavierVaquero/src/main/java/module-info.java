module com.example.examenjaviervaquero {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires java.desktop;


    opens com.example.examenjaviervaquero to javafx.fxml;
    exports com.example.examenjaviervaquero;

    exports com.example.examenjaviervaquero.controller;
    opens com.example.examenjaviervaquero.controller to javafx.fxml;

    opens com.example.examenjaviervaquero.model to lombok, java.sql;
    exports com.example.examenjaviervaquero.model;
}