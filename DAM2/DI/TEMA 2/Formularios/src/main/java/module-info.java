module com.example.formularios {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.formularios to javafx.fxml;
    exports com.example.formularios;
}