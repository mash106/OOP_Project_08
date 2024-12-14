package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateItemInfoSceneController {
    @FXML
    private ComboBox<Item> selectItemComboBox;
    @FXML
    private TextField updatedNameField;
    @FXML
    private TextField updatedCategoryField;
    @FXML
    private TextArea updatedDescriptionArea;
    @FXML
    private TextField updatedPriceField;
    @FXML
    private TextField updatedQuantityField;

    private MonitorInventorySceneController inventoryController;

    public void setInventoryController(MonitorInventorySceneController controller) {
        this.inventoryController = controller;
    }

    @FXML
    public void initialize() {
        selectItemComboBox.setOnAction(event -> populateFields());
    }

    public void loadItems() {
        selectItemComboBox.setItems(inventoryController.getInventoryList());
    }

    private void populateFields() {
        Item selectedItem = selectItemComboBox.getValue();
        if (selectedItem != null) {
            updatedNameField.setText(selectedItem.getItemName());
            updatedCategoryField.setText(selectedItem.getCategory());
            updatedDescriptionArea.setText(selectedItem.getDescription());
            updatedPriceField.setText(String.valueOf(selectedItem.getPrice()));
            updatedQuantityField.setText(String.valueOf(selectedItem.getQuantity()));
        }
    }

    @FXML
    public void updateItemInInventoryButtonOnClicked(ActionEvent actionEvent) {
        Item selectedItem = selectItemComboBox.getValue();
        if (selectedItem == null) {
            showAlert(Alert.AlertType.WARNING, "No item selected for update");
            return;
        }

        try {
            selectedItem.setQuantity(Integer.parseInt(updatedQuantityField.getText().trim()));
            selectedItem.setPrice(Double.parseDouble(updatedPriceField.getText().trim()));
            selectedItem.setDescription(updatedDescriptionArea.getText().trim());
            showAlert(Alert.AlertType.INFORMATION, "Item Updated Successfully");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Price and Quantity must be valid numbers");
        }
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
