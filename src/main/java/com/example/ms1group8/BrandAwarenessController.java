package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    public void initialize() {

    }

    @FXML
    public void handlePublishCampaign(ActionEvent actionEvent) {
        String selectedChannel = channelComboBox.getSelectionModel().getSelectedItem();
        String campaignConcept = campaignConceptArea.getText();
        String engagementMetrics = "1000 views, 500 likes";

        if (selectedChannel == null || campaignConcept.isEmpty()) {
            showAlert("Incomplete Data", "Please fill in all fields before publishing the campaign.");
        } else {
            // Code to publish the campaign using the provided data
            engagementMetricsField.setText(engagementMetrics);
            showAlert("Campaign Published", "The campaign has been published successfully on " + selectedChannel + ".");
        }
    }

    @FXML
    public void handleDevelopAssets(ActionEvent actionEvent) {
        String campaignConcept = campaignConceptArea.getText();

        if (campaignConcept.isEmpty()) {
            showAlert("No Campaign Concept", "Please provide a campaign concept before developing assets.");
        } else {
            // Code to develop assets based on the campaign concept
            showAlert("Assets Developed", "Assets have been developed for the campaign.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
