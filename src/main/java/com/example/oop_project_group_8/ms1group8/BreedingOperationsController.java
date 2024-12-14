package com.example.oop_project_group_8.ms1group8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BreedingOperationsController {

    @FXML
    private ComboBox<String> broodstockSpeciesComboBox;
    @FXML
    private TextField broodstockHealthField;
    @FXML
    private TextField spawningCycleField;
    @FXML
    private Button eggCollectionBtn;
    @FXML
    private Button fingerlingsTransferBtn;
    @FXML
    private TextArea geneticDiversityNotesArea;

    @FXML
    public void initialize() {
        broodstockSpeciesComboBox.getItems().addAll("Species A", "Species B", "Species C");
        broodstockSpeciesComboBox.setValue("Species A");
        updateHealthStatus("Species A");

        spawningCycleField.setText("Cycle 1");

        broodstockSpeciesComboBox.setOnAction(event -> {
            String selectedSpecies = broodstockSpeciesComboBox.getValue();
            updateHealthStatus(selectedSpecies);
        });
    }

    private void updateHealthStatus(String species) {
        switch (species) {
            case "Species A":
                broodstockHealthField.setText("Healthy");
                break;
            case "Species B":
                broodstockHealthField.setText("Needs Attention");
                break;
            case "Species C":
                broodstockHealthField.setText("Critical");
                break;
            default:
                broodstockHealthField.setText("Unknown");
                break;
        }
    }

    @FXML
    public void handleEggCollection(ActionEvent actionEvent) {
        String selectedSpecies = broodstockSpeciesComboBox.getValue();
        if (selectedSpecies == null || selectedSpecies.isEmpty()) {
            showAlert("No Species Selected", "Please select a species for egg collection.");
        } else {
            showAlert("Egg Collection", "Egg collection for " + selectedSpecies + " has been managed.");
        }
    }

    @FXML
    public void handleFingerlingsTransfer(ActionEvent actionEvent) {
        String selectedSpecies = broodstockSpeciesComboBox.getValue();
        if (selectedSpecies == null || selectedSpecies.isEmpty()) {
            showAlert("No Species Selected", "Please select a species for fingerlings transfer.");
        } else {
            showAlert("Fingerlings Transfer", "Fingerlings for " + selectedSpecies + " have been transferred.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void handleBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ms1group8/HatcheryTechnician.fxml"));
            AnchorPane hatcheryTechnicianPane = loader.load();

            Stage stage = (Stage) eggCollectionBtn.getScene().getWindow();

            Scene scene = new Scene(hatcheryTechnicianPane);
            stage.setScene(scene);

            HatcheryTechnicianController hatcheryTechnicianController = loader.getController();
            hatcheryTechnicianController.initialize();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while navigating back to the Hatchery Technician dashboard.");
        }
    }

    public TextArea getGeneticDiversityNotesArea() {
        return geneticDiversityNotesArea;
    }

    public void setGeneticDiversityNotesArea(TextArea geneticDiversityNotesArea) {
        this.geneticDiversityNotesArea = geneticDiversityNotesArea;
    }

    public Button getFingerlingsTransferBtn() {
        return fingerlingsTransferBtn;
    }

    public void setFingerlingsTransferBtn(Button fingerlingsTransferBtn) {
        this.fingerlingsTransferBtn = fingerlingsTransferBtn;
    }
}
