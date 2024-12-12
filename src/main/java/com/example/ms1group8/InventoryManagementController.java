package com.example.ms1group8;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryManagementController {


    @FXML
    private TableView<com.example.ms1group8.InventoryItem> inventoryTable;

    @FXML
    private TableColumn<com.example.ms1group8.InventoryItem, String> itemColumn;

    @FXML
    private TableColumn<com.example.ms1group8.InventoryItem, Integer> stockColumn;

    @FXML
    private TableColumn<com.example.ms1group8.InventoryItem, String> statusColumn;

    @FXML
    private TextField reorderThresholdField;

    @FXML
    private Button generatePOBtn;

    @FXML
    private Button setNotificationsBtn;


    private final ObservableList<com.example.ms1group8.InventoryItem> inventoryItems = FXCollections.observableArrayList();


    @FXML
    public void initialize() {

        itemColumn.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());


        inventoryItems.add(new com.example.ms1group8.InventoryItem("Fish Food", 200, "In Stock"));
        inventoryItems.add(new com.example.ms1group8.InventoryItem("Water Filter", 50, "Low Stock"));
        inventoryItems.add(new com.example.ms1group8.InventoryItem("Tank Cleaner", 0, "Out of Stock"));


        inventoryTable.setItems(inventoryItems);
    }


    @FXML
    private void handleGeneratePurchaseOrder() {

        String thresholdText = reorderThresholdField.getText();
        int reorderThreshold = 0;

        try {
            reorderThreshold = Integer.parseInt(thresholdText);
        } catch (NumberFormatException e) {
            System.out.println("Invalid threshold value");
            return;
        }


        System.out.println("Generating Purchase Order for items below reorder threshold (" + reorderThreshold + "):");
        for (com.example.ms1group8.InventoryItem item : inventoryItems) {
            if (item.getStock() < reorderThreshold) {
                System.out.println("Item: " + item.getItemName() + ", Current Stock: " + item.getStock());

            }
        }
    }


    @FXML
    private void handleSetNotifications() {

        System.out.println("Reorder notifications are set.");

    }
}
