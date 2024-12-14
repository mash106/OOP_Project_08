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

public class ManageSupplierInfoSceneController {

    @FXML
    private TableView<Supplier> supplierTable;
    @FXML
    private TableColumn<Supplier, Integer> supplierIDTC;
    @FXML
    private TableColumn<Supplier, String> supplierNameTC;
    @FXML
    private TableColumn<Supplier, String> supplierProductsTC;
    @FXML
    private TableColumn<Supplier, String> supplierContactTC;
    @FXML
    private TextField supplierNameTF;
    @FXML
    private ComboBox<String> productSuppliedCB;
    @FXML
    private TextField supplierContactTF;
    @FXML
    private Button addNewS;

    private ObservableList<Supplier> supplierList;

    @FXML
    public void initialize() {
        supplierIDTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        supplierNameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        supplierProductsTC.setCellValueFactory(new PropertyValueFactory<>("productsSupplied"));
        supplierContactTC.setCellValueFactory(new PropertyValueFactory<>("contact"));

        supplierList = FXCollections.observableArrayList();
        supplierTable.setItems(supplierList);
        productSuppliedCB.setItems(FXCollections.observableArrayList(
                "Fingerlings", "Fish Feed", "Water Quality Enhancers"
        ));
    }

    @FXML
    public void addNewSupplierButtonOnClicked(ActionEvent actionEvent) {
        String name = supplierNameTF.getText().trim();
        String productSupplied = productSuppliedCB.getValue();
        String contact = supplierContactTF.getText().trim();

        if (name.isEmpty() || productSupplied == null || contact.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please provide all supplier details.");
            return;
        }
        int newID = supplierList.size() + 1;
        Supplier newSupplier = new Supplier(newID, name, productSupplied, contact);
        supplierList.add(newSupplier);
        clearInputFields();
        showAlert(Alert.AlertType.INFORMATION, "Supplier added successfully!");
    }

    @FXML
    public void editSelectedSupplierButtonOnClicked(ActionEvent actionEvent) {
        Supplier selectedSupplier = supplierTable.getSelectionModel().getSelectedItem();

        String updatedName = supplierNameTF.getText().trim();
        String updatedProduct = productSuppliedCB.getValue();
        String updatedContact = supplierContactTF.getText().trim();

        selectedSupplier.setName(updatedName);
        selectedSupplier.setProductsSupplied(updatedProduct);
        selectedSupplier.setContact(updatedContact);

        supplierTable.refresh();
        clearInputFields();
        showAlert(Alert.AlertType.INFORMATION, "Supplier updated successfully!");
    }

    @FXML
    public void updateSupplierTableButtonOnClicked(ActionEvent actionEvent) {
        supplierTable.refresh();
        showAlert(Alert.AlertType.INFORMATION, "Supplier table updated!");
    }

    private void clearInputFields() {
        supplierNameTF.clear();
        supplierContactTF.clear();
        productSuppliedCB.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void backButtonOnClicked(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("inventoryManagerDashboardScene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
