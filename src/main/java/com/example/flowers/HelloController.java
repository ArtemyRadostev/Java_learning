package com.example.flowers;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    Button btnMasha;
    @FXML
    Button btnTanya;
    @FXML
    Button btnDay;
    @FXML
    Image imgViolet;
    @FXML
    Image imgGeranium;
    @FXML
    Image imgCrocus;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}