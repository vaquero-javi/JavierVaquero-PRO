module com.example.practicaevaluacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.practicaevaluacion to javafx.fxml;
    opens com.example.practicaevaluacion.controller to javafx.fxml;
    opens com.example.practicaevaluacion.model to javafx.base;

    exports com.example.practicaevaluacion;
}