module com.example.flowers {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.flowers to javafx.fxml;
    exports com.example.flowers;
}