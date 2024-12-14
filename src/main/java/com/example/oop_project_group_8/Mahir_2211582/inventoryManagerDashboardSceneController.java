package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class inventoryManagerDashboardSceneController
{
    private Scene scene;
    private Parent root;

    @FXML
    public void initialize() {
    }

    @FXML
    public void lowStockButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "lowStockAlertScene.fxml");

    }

    @FXML
    public void createReportButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "inventoryReportScene.fxml");
    }

    @FXML
    public void monitorInventoryButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "monitorInventoryScene.fxml");
    }

    @FXML
    public void manageSupplierButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "manageSupplierInfoScene.fxml");
    }

    @FXML
    public void updateItemsButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "updateItemInfoScene.fxml");
    }

    @FXML
    public void trackCostButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "trackCostScene.fxml");
    }

    @FXML
    public void addItemsButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "addNewProductToInventoryScene.fxml");
    }


    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void orderFromSuppliersButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "contactSupportScene.fxml");
    }
}