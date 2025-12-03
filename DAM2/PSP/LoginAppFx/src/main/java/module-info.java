module com.example.loginappfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loginappfx to javafx.fxml;
    exports com.example.loginappfx;
}