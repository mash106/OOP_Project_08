package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WaterQualityController
{
    @javafx.fxml.FXML
    private TextArea treatmentNotesArea;
    @javafx.fxml.FXML
    private TextField temperatureField;
    @javafx.fxml.FXML
    private TextField oxygenLevelsField;
    @javafx.fxml.FXML
    private ComboBox tankSelectionComboBox;
    @javafx.fxml.FXML
    private TextField phLevelField;
    @javafx.fxml.FXML
    private Button waterTreatmentBtn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleWaterTreatment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTankReadings(ActionEvent actionEvent) {
    }
}