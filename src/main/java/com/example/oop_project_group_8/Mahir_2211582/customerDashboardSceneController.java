package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class customerDashboardSceneController {

    private Scene scene;
    private Parent root;

    @FXML
    public void initialize() {
    }
    @FXML
    public void contactSupportButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "contactSupportScene.fxml");
    }


    @FXML
    public void orderHistoryButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "orderHistoryScene.fxml");
    }

    @FXML
    public void placeOrderButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "placingOrderScene.fxml");    }

    @FXML
    public void submitReviewButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "reviewProductScene.fxml");
    }

    @FXML
    public void browseProductsButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "browseProductScene.fxml");
    }

    @FXML
    public void requestRefundButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "requestRefundScene.fxml");
    }

    @FXML
    public void trackOrderButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "trackingOrderScene.fxml");
    }

    @FXML
    public void viewProductsButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "productDetailScene.fxml");
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
    public void logoutButtonOnClickedDB(ActionEvent event) {
        switchScene(event, "loginScene.fxml");

    }
}