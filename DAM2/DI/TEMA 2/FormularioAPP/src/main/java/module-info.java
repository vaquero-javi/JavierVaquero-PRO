module com.example.formularioapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires lombok;
    requires java.desktop;

    opens com.example.formularioapp to javafx.fxml;
    exports com.example.formularioapp;

    opens com.example.formularioapp.model to lombok;
    exports com.example.formularioapp.model;
    exports com.example.formularioapp.controller;
    opens com.example.formularioapp.controller to javafx.fxml;
}