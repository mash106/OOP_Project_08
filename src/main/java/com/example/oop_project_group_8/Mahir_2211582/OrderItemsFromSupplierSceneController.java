package com.example.oop_project_group_8.Mahir_2211582;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrderItemsFromSupplierSceneController {

    @javafx.fxml.FXML
    private TableView<Item> restockItemsTable;

    @javafx.fxml.FXML
    private TableColumn<Item, String> restockItemIdTC;

    @javafx.fxml.FXML
    private TableColumn<Item, String> restockItemCategoryTC;

    @javafx.fxml.FXML
    private TableColumn<Item, Integer> restockItemQuantityTC;

    @javafx.fxml.FXML
    private ComboBox<String> selectSupplierComboBox;

    private ObservableList<Item> inventoryList;

    @javafx.fxml.FXML
    public void initialize() {
        inventoryList = InventoryData.getInventoryList();

        restockItemIdTC.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        restockItemCategoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        restockItemQuantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        restockItemsTable.setItems(inventoryList);
        ObservableList<String> suppliers = FXCollections.observableArrayList(
                "Supplier A",
                "Supplier B",
                "Supplier C",
                "Supplier D"
        );
        selectSupplierComboBox.setItems(suppliers);
    }

    @javafx.fxml.FXML
    public void placeRestockOrderButtonOnAction(ActionEvent actionEvent) {
        Item selectedItem = restockItemsTable.getSelectionModel().getSelectedItem();
        String selectedSupplier = selectSupplierComboBox.getValue();


        // Process the order (mock functionality)
        String message = String.format(
                "Order placed successfully for item '%s' from supplier '%s'.",
                selectedItem.getItemName(),
                selectedSupplier
        );

        showAlert(Alert.AlertType.INFORMATION, "Order Placed", message);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
