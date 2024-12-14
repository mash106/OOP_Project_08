package com.example.oop_project_group_8.ms1group8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SalesAndMarketingManagerController {

    private Stage stage;
    private Scene scene;

    @FXML
    public void handleManageCustomerOrders(ActionEvent event) {
        switchScene(event, "ManageCustomerOrders.fxml");
    }

    @FXML
    public void handleTrackMarketTrends(ActionEvent event) {
        switchScene(event, "TrackMarketTrendsAndPriceAnalysis.fxml");
    }

    @FXML
    public void handleGenerateSalesReports(ActionEvent event) {
        switchScene(event, "GenerateSalesReports.fxml");
    }

    @FXML
    public void handleManageMarketingCampaigns(ActionEvent event) {
        switchScene(event, "ManageMarketingCampaigns.fxml");
    }

    @FXML
    public void handleCustomerRelationshipManagement(ActionEvent event) {
        switchScene(event, "HandleCustomerRelationshipManagement.fxml");
    }

    @FXML
    public void handleMonitorInventory(ActionEvent event) {
        switchScene(event, "MonitorInventoryForSalesPlanning.fxml");
    }

    @FXML
    public void handleDevelopSeasonalPromotions(ActionEvent event) {
        switchScene(event, "DevelopSeasonalPromotionStrategies.fxml");
    }

    @FXML
    public void handleEnhanceBrandAwareness(ActionEvent event) {
        switchScene(event, "EnhanceBrandAwareness.fxml");
    }

    @FXML
    public void handleBackButton(ActionEvent event) {
        switchScene(event, "SalesAndMarketingManager.fxml");
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
        }
    }

    public void initialize() {
    }
}
