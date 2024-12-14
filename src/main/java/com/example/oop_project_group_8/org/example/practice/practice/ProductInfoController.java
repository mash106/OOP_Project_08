package com.example.oop_project_group_8.org.example.practice.practice;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ProductInfoController {

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productCodeField;

    @FXML
    private Label productDetailsLabel;

    @FXML
    private Button fetchProductButton;

    @FXML
    private Button backButton;

    @FXML
    public void fetchProductDetails() {
        String productName = productNameField.getText().trim();
        String productCode = productCodeField.getText().trim();

        if (productName.isEmpty() || productCode.isEmpty()) {
            showAlert("Error", "Please enter both Product Name and Product Code.");
        } else {
            String productDetails = "Name: " + productName + "\nCode: " + productCode + "\nDetails: Example Product Information";
            productDetailsLabel.setText(productDetails);
        }
    }

    @FXML
    public void handleBackAction() {
        showAlert("Navigation", "Returning to the previous screen...");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
