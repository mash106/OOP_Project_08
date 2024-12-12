package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class FeedDistributionController
{
    @javafx.fxml.FXML
    private TextField feedQuantityField;
    @javafx.fxml.FXML
    private Button updateInventoryBtn;
    @javafx.fxml.FXML
    private ComboBox feedTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox tankNumberComboBox;
    @javafx.fxml.FXML
    private TextField currentInventoryField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleUpdateInventory(ActionEvent actionEvent) {
    }
}