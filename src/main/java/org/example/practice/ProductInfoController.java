package org.example.practice;

import javafx.fxml.FXML;
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
    public void initialize() {

        fetchProductButton.setOnAction(event -> fetchProductDetails());
    }

    private void fetchProductDetails() {
        String productName = productNameField.getText();
        String productCode = productCodeField.getText();


        if (productName.trim().isEmpty() || productCode.trim().isEmpty()) {
            productDetailsLabel.setText("Please provide both product name and code.");
        } else {

            productDetailsLabel.setText("Product Details:\nName: " + productName + "\nCode: " + productCode);
        }
    }
}
