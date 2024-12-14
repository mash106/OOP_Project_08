package com.example.oop_project_group_8.Tasin_2211161;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class OrderManagementController {

    @FXML
    private TextField customerNameField;

    @FXML
    private ComboBox<String> fishSpeciesComboBox;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField totalPriceField;

    @FXML
    private Button confirmOrderBtn;

    @FXML
    private Button backBtn;

    @FXML
    public void initialize() {
        ObservableList<String> fishSpecies = FXCollections.observableArrayList("Tilapia", "Rohu", "Catla", "Grass Carp", "Pangasius");
        fishSpeciesComboBox.setItems(fishSpecies);
    }

    @FXML
    private void handleConfirmOrder() {
        String customerName = customerNameField.getText();
        String fishSpecies = fishSpeciesComboBox.getValue();
        String quantityText = quantityField.getText();

        if (customerName.isEmpty() || fishSpecies == null || quantityText.isEmpty()) {
            showAlert("Error", "Please enter a customer name, select a fish species, and enter a quantity.");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid quantity. Please enter a valid number.");
            return;
        }

        double PRICE_PER_FISH = 10.0;
        double totalPrice = quantity * PRICE_PER_FISH;

        totalPriceField.setText(String.format("Tk%.2f", totalPrice));

        showAlert("Order Confirmed", "Order for " + customerName + " has been confirmed!");

        System.out.println("Order confirmed!");
        System.out.println("Customer: " + customerName);
        System.out.println("Fish Species: " + fishSpecies);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: Tk" + totalPrice);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/ms1group8/SalesAndMarketingManager.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Button getConfirmOrderBtn() {
        return confirmOrderBtn;
    }

    public void setConfirmOrderBtn(Button confirmOrderBtn) {
        this.confirmOrderBtn = confirmOrderBtn;
    }

    public Button getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(Button backBtn) {
        this.backBtn = backBtn;
    }
}
