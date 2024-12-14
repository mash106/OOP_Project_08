package com.example.oop_project_group_8.Tasin_2211161;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HatcheryTechnicianController {

    private Stage stage;
    private Scene scene;

    @FXML
    public void handleMonitorFishHealth(ActionEvent event) {
        switchScene(event, "MonitorFishHealth.fxml");
    }

    @FXML
    public void handleTrackFeedDistribution(ActionEvent event) {
        switchScene(event, "TrackFeedDistribution.fxml");
    }

    @FXML
    public void handleOverseeBreeding(ActionEvent event) {
        switchScene(event, "OverseeBreeding.fxml");
    }

    @FXML
    public void handleMaintainFishStock(ActionEvent event) {
        switchScene(event, "MaintainFishStock.fxml");
    }

    @FXML
    public void handleHandleFishTransportation(ActionEvent event) {
        switchScene(event, "HandleFishTransportation.fxml");
    }

    @FXML
    public void handleManageInventory(ActionEvent event) {
        switchScene(event, "ManageInventory.fxml");
    }

    @FXML
    public void handleMaintainWaterQuality(ActionEvent event) {
        switchScene(event, "MaintainWaterQuality.fxml");
    }

    @FXML
    public void handleHatcheryEquipment(ActionEvent event) {
        switchScene(event, "HatcheryEquipment.fxml");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        switchScene(event, "HatcheryTechnician.fxml");
    }

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading scene: " + fxmlFile);
        }
    }

    public void initialize() {
    }
}
