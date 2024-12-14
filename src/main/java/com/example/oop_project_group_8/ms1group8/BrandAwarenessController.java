package com.example.oop_project_group_8.ms1group8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class BrandAwarenessController {

    @FXML
    private Button publishCampaignBtn;
    @FXML
    private ComboBox<String> channelComboBox;
    @FXML
    private Button developAssetsBtn;
    @FXML
    private TextField engagementMetricsField;
    @FXML
    private TextArea campaignConceptArea;

    @FXML
    private Button backBtn;

    @FXML
    public void initialize() {

        channelComboBox.setOnAction(this::updateEngagementMetrics);
    }

    private void updateEngagementMetrics(ActionEvent actionEvent) {
        String selectedChannel = channelComboBox.getSelectionModel().getSelectedItem();
        String engagementMetrics = "";

        if (selectedChannel != null) {
            switch (selectedChannel) {
                case "Social Media":
                    engagementMetrics = "5000 views, 1000 likes, 200 shares";
                    break;
                case "Website":
                    engagementMetrics = "3000 visits, 200 sign-ups";
                    break;
                case "Email Marketing":
                    engagementMetrics = "10000 emails sent, 1500 clicks";
                    break;
                case "Print Media":
                    engagementMetrics = "500 brochures distributed, 50 calls received";
                    break;
                default:
                    engagementMetrics = "No data available";
            }
        }

        engagementMetricsField.setText(engagementMetrics);
    }

    @FXML
    public void handlePublishCampaign(ActionEvent actionEvent) {
        String selectedChannel = channelComboBox.getSelectionModel().getSelectedItem();
        String campaignConcept = campaignConceptArea.getText();

        if (selectedChannel == null || campaignConcept.isEmpty()) {
            showAlert("Incomplete Data", "Please fill in all fields before publishing the campaign.");
        } else {
            showAlert("Campaign Published", "The campaign has been published successfully on " + selectedChannel + ".");
        }
    }

    @FXML
    public void handleDevelopAssets(ActionEvent actionEvent) {
        String campaignConcept = campaignConceptArea.getText();

        if (campaignConcept.isEmpty()) {
            showAlert("No Campaign Concept", "Please provide a campaign concept before developing assets.");
        } else {
            showAlert("Assets Developed", "Assets have been developed for the campaign.");
        }
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/ms1group8/SalesAndMarketingManager.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Button getPublishCampaignBtn() {
        return publishCampaignBtn;
    }

    public void setPublishCampaignBtn(Button publishCampaignBtn) {
        this.publishCampaignBtn = publishCampaignBtn;
    }

    public Button getDevelopAssetsBtn() {
        return developAssetsBtn;
    }

    public void setDevelopAssetsBtn(Button developAssetsBtn) {
        this.developAssetsBtn = developAssetsBtn;
    }

    public Button getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(Button backBtn) {
        this.backBtn = backBtn;
    }
}
