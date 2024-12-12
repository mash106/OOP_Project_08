package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class OrderManagementController
{
    @javafx.fxml.FXML
    private TextField totalPriceField;
    @javafx.fxml.FXML
    private Button confirmOrderBtn;
    @javafx.fxml.FXML
    private ComboBox fishSpeciesComboBox;
    @javafx.fxml.FXML
    private TextField quantityField;
    @javafx.fxml.FXML
    private ComboBox customerComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleConfirmOrder(ActionEvent actionEvent) {
    }
}