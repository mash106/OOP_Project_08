package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InventoryManagementController
{
    @javafx.fxml.FXML
    private TableView inventoryTable;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Button setNotificationsBtn;
    @javafx.fxml.FXML
    private Button generatePOBtn;
    @javafx.fxml.FXML
    private TableColumn itemColumn;
    @javafx.fxml.FXML
    private TextField reorderThresholdField;
    @javafx.fxml.FXML
    private TableColumn stockColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleGeneratePurchaseOrder(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSetNotifications(ActionEvent actionEvent) {
    }
}