module com.example.exmordjaviervaquerofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    opens com.example.exmordjaviervaquerofx to javafx.fxml;
    exports com.example.exmordjaviervaquerofx;

    exports com.example.exmordjaviervaquerofx.controller;
    opens com.example.exmordjaviervaquerofx.controller to javafx.fxml;


}