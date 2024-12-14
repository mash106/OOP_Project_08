package com.example.oop_project_group_8.Tasin_2211161;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.IOException;

public class InventorySalesPlanningController {

    @FXML
    private TableView<InventoryItem> inventoryTable;

    @FXML
    private TableColumn<InventoryItem, String> productColumn;

    @FXML
    private TableColumn<InventoryItem, Integer> stockColumn;

    @FXML
    private TableColumn<InventoryItem, Integer> demandColumn;

    @FXML
    private TextField demandForecastField;

    @FXML
    private Button updateProductionBtn;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<String> productComboBox;

    private final ObservableList<InventoryItem> inventoryItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        productColumn.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
        stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        demandColumn.setCellValueFactory(cellData -> cellData.getValue().demandProperty().asObject());

        inventoryItems.add(new InventoryItem("Fish Food", 200, 150));
        inventoryItems.add(new InventoryItem("Water Filter", 50, 70));
        inventoryItems.add(new InventoryItem("Tank Cleaner", 0, 30));
        inventoryItems.add(new InventoryItem("Algae Remover", 100, 120));
        inventoryItems.add(new InventoryItem("Filter Cartridge", 300, 250));
        inventoryItems.add(new InventoryItem("Fish Tank", 10, 15));

        inventoryTable.setItems(inventoryItems);

        ObservableList<String> productNames = FXCollections.observableArrayList();
        for (InventoryItem item : inventoryItems) {
            productNames.add(item.getItemName());
        }
        productComboBox.setItems(productNames);
    }

    @FXML
    private void handleUpdateProduction() {
        int totalDemand = inventoryItems.stream().mapToInt(InventoryItem::getDemand).sum();
        demandForecastField.setText(String.valueOf(totalDemand));
    }

    @FXML
    private void handleProductSelection(ActionEvent event) {
        String selectedProduct = productComboBox.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            InventoryItem selectedItem = inventoryItems.stream()
                    .filter(item -> item.getItemName().equals(selectedProduct))
                    .findFirst()
                    .orElse(null);

            if (selectedItem != null) {
                demandForecastField.setText(String.valueOf(selectedItem.getDemand()));
            }
        }
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

    public Button getUpdateProductionBtn() {
        return updateProductionBtn;
    }

    public void setUpdateProductionBtn(Button updateProductionBtn) {
        this.updateProductionBtn = updateProductionBtn;
    }

    public Button getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(Button backBtn) {
        this.backBtn = backBtn;
    }

    public static class InventoryItem {
        private final StringProperty itemName;
        private final IntegerProperty stock;
        private final IntegerProperty demand;

        public InventoryItem(String itemName, int stock, int demand) {
            this.itemName = new SimpleStringProperty(itemName);
            this.stock = new SimpleIntegerProperty(stock);
            this.demand = new SimpleIntegerProperty(demand);
        }

        public StringProperty itemNameProperty() {
            return itemName;
        }

        public IntegerProperty stockProperty() {
            return stock;
        }

        public IntegerProperty demandProperty() {
            return demand;
        }

        public String getItemName() {
            return itemName.get();
        }

        public int getStock() {
            return stock.get();
        }

        public int getDemand() {
            return demand.get();
        }
    }
}
