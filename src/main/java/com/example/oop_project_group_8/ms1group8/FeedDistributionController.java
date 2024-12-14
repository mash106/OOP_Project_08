package com.example.oop_project_group_8.ms1group8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class FeedDistributionController {

    @FXML
    private ComboBox<String> tankNumberComboBox;
    @FXML
    private ComboBox<String> feedTypeComboBox;
    @FXML
    private TextField feedQuantityField;
    @FXML
    private TextField currentInventoryField;
    @FXML
    private Button updateInventoryBtn;

    private final ObservableList<String> tankNumbers = FXCollections.observableArrayList("Tank 1", "Tank 2", "Tank 3", "Tank 4", "Tank 5");
    private final ObservableList<String> feedTypes = FXCollections.observableArrayList("Starter", "Grower", "Finisher");
    private int currentInventory = 1000;

    @FXML
    public void initialize() {
        tankNumberComboBox.setItems(tankNumbers);
        feedTypeComboBox.setItems(feedTypes);

        updateInventoryField();
    }

    @FXML
    public void handleUpdateInventory(ActionEvent event) {
        try {
            String selectedTank = tankNumberComboBox.getSelectionModel().getSelectedItem();
            String selectedFeed = feedTypeComboBox.getSelectionModel().getSelectedItem();
            String feedQuantityText = feedQuantityField.getText();

            if (selectedTank == null || selectedFeed == null) {
                showAlert("Error", "Please select both a tank number and feed type.");
                return;
            }

            if (feedQuantityText.isEmpty()) {
                showAlert("Error", "Please enter the feed quantity.");
                return;
            }

            int feedQuantity = Integer.parseInt(feedQuantityText);
            if (feedQuantity <= 0) {
                showAlert("Error", "Feed quantity must be a positive number.");
                return;
            }

            if (feedQuantity > currentInventory) {
                showAlert("Error", "Insufficient inventory to fulfill this order.");
                return;
            }

            currentInventory -= feedQuantity;
            updateInventoryField();

            showAlert("Success", "Feed distribution updated successfully for " + selectedTank + " using " + selectedFeed + " feed type.");

        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid feed quantity. Please enter a valid number.");
        }
    }

    private void updateInventoryField() {
        currentInventoryField.setText(String.valueOf(currentInventory));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HatcheryTechnician.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Button getUpdateInventoryBtn() {
        return updateInventoryBtn;
    }

    public void setUpdateInventoryBtn(Button updateInventoryBtn) {
        this.updateInventoryBtn = updateInventoryBtn;
    }
}
