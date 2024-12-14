package com.example.oop_project_group_8.ms1group8;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

import java.io.IOException;

public class WaterQualityController {

    @FXML
    private ComboBox<String> tankSelectionComboBox;

    @FXML
    private TextField phLevelField;

    @FXML
    private TextField temperatureField;

    @FXML
    private TextField oxygenLevelsField;

    @FXML
    private Button waterTreatmentBtn;

    @FXML
    private TextArea treatmentNotesArea;

    @FXML
    public void initialize() {
        tankSelectionComboBox.setItems(FXCollections.observableArrayList("Tank 1", "Tank 2", "Tank 3", "Tank 4"));
        tankSelectionComboBox.setOnAction(this::loadTankReadings);
    }

    @FXML
    private void loadTankReadings(ActionEvent event) {
        String selectedTank = tankSelectionComboBox.getValue();

        if (selectedTank != null) {
            switch (selectedTank) {
                case "Tank 1":
                    phLevelField.setText("7.2");
                    temperatureField.setText("22°C");
                    oxygenLevelsField.setText("8.5 mg/L");
                    break;
                case "Tank 2":
                    phLevelField.setText("6.8");
                    temperatureField.setText("20°C");
                    oxygenLevelsField.setText("7.8 mg/L");
                    break;
                case "Tank 3":
                    phLevelField.setText("7.5");
                    temperatureField.setText("24°C");
                    oxygenLevelsField.setText("9.0 mg/L");
                    break;
                case "Tank 4":
                    phLevelField.setText("6.5");
                    temperatureField.setText("18°C");
                    oxygenLevelsField.setText("6.5 mg/L");
                    break;
                default:
                    phLevelField.clear();
                    temperatureField.clear();
                    oxygenLevelsField.clear();
            }
        } else {
            phLevelField.clear();
            temperatureField.clear();
            oxygenLevelsField.clear();
        }
    }

    @FXML
    private void handleWaterTreatment(ActionEvent event) {
        String treatmentNotes = "Water treatment initiated for selected tank.";
        treatmentNotesArea.setText(treatmentNotes);
    }

    @FXML
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HatcheryTechnician.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Button getWaterTreatmentBtn() {
        return waterTreatmentBtn;
    }

    public void setWaterTreatmentBtn(Button waterTreatmentBtn) {
        this.waterTreatmentBtn = waterTreatmentBtn;
    }
}
