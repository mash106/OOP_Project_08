package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class MarketingCampaignController
{
    @javafx.fxml.FXML
    private Button createCampaignBtn;
    @javafx.fxml.FXML
    private TableView campaignTable;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private TableColumn campaignColumn;
    @javafx.fxml.FXML
    private TextArea campaignConceptArea;
    @javafx.fxml.FXML
    private TableColumn roiColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCreateCampaign(ActionEvent actionEvent) {
    }
}