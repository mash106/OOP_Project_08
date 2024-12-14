package com.example.oop_project_group_8.Mahir_2211582;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class PlacingOrderSceneController {

    @FXML
    private TableView<CartItem> cartTable;
    @FXML
    private ComboBox<String> paymentMethodComboBox;
    @FXML
    private TableColumn<CartItem, String> cartProductTC;
    @FXML
    private TableColumn<CartItem, Integer> cartQuantityTC;
    @FXML
    private TableColumn<CartItem, Double> cartPriceTC;
    @FXML
    private TextField cartAddressField;
    @FXML
    private TextField cartNameField;
    @FXML
    private TextField cardNumberTF;

    private ObservableList<CartItem> cartItems;

    @FXML
    public void initialize() {

        cartProductTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        cartQuantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cartPriceTC.setCellValueFactory(new PropertyValueFactory<>("price"));

        cartItems = FXCollections.observableArrayList();
        cartTable.setItems(cartItems);

        paymentMethodComboBox.setItems(FXCollections.observableArrayList("Cash on Delivery", "Card Payment"));


        paymentMethodComboBox.setOnAction(event -> {
            if ("Card Payment".equals(paymentMethodComboBox.getValue())) {
                cardNumberTF.setDisable(false);
            } else {
                cardNumberTF.setDisable(true);
                cardNumberTF.clear();
            }
        });

        cardNumberTF.setDisable(true);
    }

    @Deprecated
    public void addToCart(String productName, int quantity, double price) {

        for (CartItem item : cartItems) {
            if (item.getProductName().equals(productName)) {
                item.setQuantity(item.getQuantity() + quantity);
                cartTable.refresh();
                return;
            }
        }


        cartItems.add(new CartItem(productName, quantity, price));
    }

    @FXML
    public void placeOrderButtonOnClicked(ActionEvent actionEvent) {
        String name = cartNameField.getText();
        String address = cartAddressField.getText();
        String paymentMethod = paymentMethodComboBox.getValue();
        String cardNumber = cardNumberTF.getText();

        if (name.isEmpty() || address.isEmpty() || paymentMethod == null) {
            showAlert("Error", "Please fill in all required fields.", Alert.AlertType.ERROR);
            return;
        }

        if ("Card Payment".equals(paymentMethod) && (cardNumber.isEmpty() || !cardNumber.matches("\\d{16}"))) {
            showAlert("Error", "Please enter a valid 16-digit card number.", Alert.AlertType.ERROR);
            return;
        }

        showAlert("Success", "Order placed successfully!", Alert.AlertType.INFORMATION);

        cartItems.clear();
        cartNameField.clear();
        cartAddressField.clear();
        paymentMethodComboBox.getSelectionModel().clearSelection();
        cardNumberTF.clear();
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void backButtonOnClicked(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("customerDashboardScene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
