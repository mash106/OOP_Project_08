package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
        // Adding sample broodstock species to the ComboBox
        broodstockSpeciesComboBox.getItems().addAll(
                "Tilapia",
                "Catfish",
                "Salmon",
                "Trout",
                "Bass"
        );

        // Add event listener to the ComboBox to update broodstock info
        broodstockSpeciesComboBox.setOnAction(this::updateBroodstockInfo);
    }

    private void updateBroodstockInfo(ActionEvent event) {
        String selectedSpecies = broodstockSpeciesComboBox.getSelectionModel().getSelectedItem();
        if (selectedSpecies != null) {
            switch (selectedSpecies) {
                case "Tilapia":
                    broodstockHealthField.setText("Healthy");
                    spawningCycleField.setText("Monthly");
                    break;
                case "Catfish":
                    broodstockHealthField.setText("Good");
                    spawningCycleField.setText("Bi-Monthly");
                    break;
                case "Salmon":
                    broodstockHealthField.setText("Excellent");
                    spawningCycleField.setText("Yearly");
                    break;
                case "Trout":
                    broodstockHealthField.setText("Fair");
                    spawningCycleField.setText("Seasonal");
                    break;
                case "Bass":
                    broodstockHealthField.setText("Good");
                    spawningCycleField.setText("Quarterly");
                    break;
            }
        }
    }

    @FXML
    public void handleEggCollection(ActionEvent actionEvent) {
        String selectedSpecies = broodstockSpeciesComboBox.getSelectionModel().getSelectedItem();
        String geneticNotes = geneticDiversityNotesArea.getText();

        if (selectedSpecies == null) {
            showAlert("No Species Selected", "Please select a broodstock species before managing egg collection.");
        } else {
            // Code to handle egg collection based on the selected species and provided genetic notes
            showAlert("Egg Collection Managed", "Egg collection for " + selectedSpecies + " has been managed. Notes: " + geneticNotes);
        }
    }

    @FXML
    public void handleFingerlingsTransfer(ActionEvent actionEvent) {
        String selectedSpecies = broodstockSpeciesComboBox.getSelectionModel().getSelectedItem();

        if (selectedSpecies == null) {
            showAlert("No Species Selected", "Please select a broodstock species before transferring fingerlings.");
        } else {
            // Code to handle fingerlings transfer based on the selected species
            showAlert("Fingerlings Transferred", "Fingerlings for " + selectedSpecies + " have been transferred.");
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
