package com.example.javafx3;

import com.example.gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Alerts.showAlert("Alert title", "Alert header", "Hello", Alert.AlertType.INFORMATION);

        welcomeText.setText("Welcome to JavaFX Application!");
    }

}