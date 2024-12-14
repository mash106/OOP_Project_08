package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class LowStockAlertSceneController
{

    @javafx.fxml.FXML
    private TableColumn lowStockItemidTC;
    @javafx.fxml.FXML
    private TableColumn lowStockItemRestockTC;
    @javafx.fxml.FXML
    private TableColumn lowStockItemQuantityTC;
    @javafx.fxml.FXML
    private TableView lowStockAlertsTV;
    @javafx.fxml.FXML
    private TableColumn lowStockItemNameTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void restockButtonOnClicked(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
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