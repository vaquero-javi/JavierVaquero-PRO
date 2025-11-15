module com.example.calculadorafx {
    requires javafx.controls;
    requires javafx.fxml;


    requires lombok;
    requires java.desktop;



    opens com.example.calculadorafx to javafx.fxml;
    exports com.example.calculadorafx;

    exports com.example.calculadorafx.controller;
    opens com.example.calculadorafx.controller to javafx.fxml;

    opens com.example.calculadorafx.model to lombok;
    exports com.example.calculadorafx.model;

}