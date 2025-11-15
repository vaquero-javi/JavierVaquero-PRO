module com.example.formularioapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires java.sql;
    requires lombok;
    requires java.desktop;

    opens com.example.formularioapp to javafx.fxml, java.sql;
    exports com.example.formularioapp;

    exports com.example.formularioapp.controller;
    opens com.example.formularioapp.controller to javafx.fxml,java.sql;

    opens com.example.formularioapp.model to lombok,java.sql;
    exports com.example.formularioapp.model;
}