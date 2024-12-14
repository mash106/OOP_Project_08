package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddNewProductToInventorySceneController {
    @FXML
    private TextArea descriptionArea;
    @FXML
    private TextField priceField;
    @FXML
    private TextField itemNameField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField quantityField;

    private MonitorInventorySceneController inventoryController;

    public void setInventoryController(MonitorInventorySceneController controller) {
        this.inventoryController = controller;
    }

    @FXML
    public void addItemToInventoryButtonOnAction(ActionEvent actionEvent) {
        String itemName = itemNameField.getText().trim();
        String category = categoryField.getText().trim();
        String description = descriptionArea.getText().trim();
        String priceText = priceField.getText().trim();
        String quantityText = quantityField.getText().trim();

        if (itemName.isEmpty() || category.isEmpty() || description.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please Provide The Necessary Info");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            int quantity = Integer.parseInt(quantityText);
            Item newItem = new Item(itemName, category, description, price, quantity);
            inventoryController.getInventoryList().add(newItem);
            showAlert(Alert.AlertType.INFORMATION, "Item Has Been Added To Inventory");
            clearFields();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Price and Quantity must be valid numbers");
        }
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        itemNameField.clear();
        categoryField.clear();
        descriptionArea.clear();
        priceField.clear();
        quantityField.clear();
    }
}
