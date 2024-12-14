package com.example.oop_project_group_8.ms1group8;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InventoryManagementController {

    @FXML
    private TableView<InventoryItem> inventoryTable;

    @FXML
    private TableColumn<InventoryItem, String> itemColumn;

    @FXML
    private TableColumn<InventoryItem, Integer> stockColumn;

    @FXML
    private TableColumn<InventoryItem, String> statusColumn;

    @FXML
    private TextField reorderThresholdField;

    @FXML
    private Button generatePOBtn;

    @FXML
    private Button setNotificationsBtn;

    private final ObservableList<InventoryItem> inventoryItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        itemColumn.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        inventoryItems.add(new InventoryItem("Fish Food", 200, "In Stock"));
        inventoryItems.add(new InventoryItem("Water Filter", 50, "Low Stock"));
        inventoryItems.add(new InventoryItem("Tank Cleaner", 0, "Out of Stock"));

        inventoryTable.setItems(inventoryItems);
    }

    @FXML
    private void handleGeneratePurchaseOrder() {
        String thresholdText = reorderThresholdField.getText();
        int reorderThreshold;

        try {
            reorderThreshold = Integer.parseInt(thresholdText);
        } catch (NumberFormatException e) {
            System.out.println("Invalid threshold value");
            return;
        }

        System.out.println("Generating Purchase Order for items below reorder threshold (" + reorderThreshold + "):");
        for (InventoryItem item : inventoryItems) {
            if (item.getStock() < reorderThreshold) {
                System.out.println("Item: " + item.getItemName() + ", Current Stock: " + item.getStock());
            }
        }
    }

    @FXML
    private void handleSetNotifications() {
        System.out.println("Reorder notifications are set.");
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

    public Button getGeneratePOBtn() {
        return generatePOBtn;
    }

    public void setGeneratePOBtn(Button generatePOBtn) {
        this.generatePOBtn = generatePOBtn;
    }

    public Button getSetNotificationsBtn() {
        return setNotificationsBtn;
    }

    public void setSetNotificationsBtn(Button setNotificationsBtn) {
        this.setNotificationsBtn = setNotificationsBtn;
    }
}
