package com.example.ms1group8;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MarketingCampaignController {

    @FXML
    private TableView<Campaign> campaignTable;

    @FXML
    private TableColumn<Campaign, String> campaignColumn;

    @FXML
    private TableColumn<Campaign, String> statusColumn;

    @FXML
    private TableColumn<Campaign, String> roiColumn;

    @FXML
    private TextArea campaignConceptArea;

    @FXML
    private Button createCampaignBtn;

    @FXML
    private Button backBtn;

    private ObservableList<Campaign> campaignData;

    @FXML
    public void initialize() {
        campaignColumn.setCellValueFactory(cellData -> cellData.getValue().campaignNameProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        roiColumn.setCellValueFactory(cellData -> cellData.getValue().roiProperty());

        campaignData = FXCollections.observableArrayList();
        campaignData.add(new Campaign("Tilapia Promotion", "Active", "150%"));
        campaignData.add(new Campaign("Rohu Market Expansion", "Completed", "200%"));
        campaignData.add(new Campaign("Catla Seasonal Offer", "Pending", "120%"));
        campaignData.add(new Campaign("Pangasius Bulk Sales", "Active", "180%"));
        campaignData.add(new Campaign("Grass Carp Discount", "Completed", "160%"));

        campaignTable.setItems(campaignData);
    }

    @FXML
    private void handleCreateCampaign() {
        String campaignConcept = campaignConceptArea.getText();

        if (campaignConcept.isEmpty()) {
            showAlert(AlertType.ERROR, "Error", "Please describe the new campaign concept.");
            return;
        }

        Campaign newCampaign = new Campaign("New Campaign", "Planned", "100%");
        campaignData.add(newCampaign);

        campaignConceptArea.clear();

        showAlert(AlertType.INFORMATION, "Campaign Created", "New campaign has been created!\n\nConcept: " + campaignConcept);

        System.out.println("New campaign created: " + newCampaign.getCampaignName());
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SalesAndMarketingManager.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Button getCreateCampaignBtn() {
        return createCampaignBtn;
    }

    public void setCreateCampaignBtn(Button createCampaignBtn) {
        this.createCampaignBtn = createCampaignBtn;
    }

    public Button getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(Button backBtn) {
        this.backBtn = backBtn;
    }
}