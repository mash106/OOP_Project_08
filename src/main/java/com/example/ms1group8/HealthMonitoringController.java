package com.example.ms1group8;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HealthMonitoringController {


    @FXML
    private ComboBox<String> tankIdComboBox;

    @FXML
    private ComboBox<String> fishSpeciesComboBox;

    @FXML
    private TextField mortalityCountField;

    @FXML
    private TextArea behaviorTextArea;

    @FXML
    private ComboBox<String> appetiteComboBox;

    @FXML
    private Button submitHealthAssessmentBtn;


    private final ObservableList<String> tankList = FXCollections.observableArrayList("Tank A", "Tank B", "Tank C");
    private final ObservableList<String> fishSpeciesList = FXCollections.observableArrayList("Tilapia", "Catfish", "Salmon");
    private final ObservableList<String> appetiteLevels = FXCollections.observableArrayList("Normal", "Decreased", "Increased");

    @FXML
    public void initialize() {
        // Set items for ComboBoxes
        tankIdComboBox.setItems(tankList);
        fishSpeciesComboBox.setItems(fishSpeciesList);
        appetiteComboBox.setItems(appetiteLevels);
    }


    @FXML
    private void handleSubmitHealthAssessment() {

        String selectedTank = tankIdComboBox.getValue();
        String selectedSpecies = fishSpeciesComboBox.getValue();
        String mortalityCount = mortalityCountField.getText();
        String behavior = behaviorTextArea.getText();
        String appetiteLevel = appetiteComboBox.getValue();


        if (selectedTank == null || selectedSpecies == null || mortalityCount.isEmpty() || appetiteLevel == null) {
            System.out.println("Please fill out all fields.");
        } else {

            System.out.println("Health Assessment Submitted:");
            System.out.println("Tank: " + selectedTank);
            System.out.println("Species: " + selectedSpecies);
            System.out.println("Mortality Count: " + mortalityCount);
            System.out.println("Behavior: " + behavior);
            System.out.println("Appetite: " + appetiteLevel);


            tankIdComboBox.getSelectionModel().clearSelection();
            fishSpeciesComboBox.getSelectionModel().clearSelection();
            mortalityCountField.clear();
            behaviorTextArea.clear();
            appetiteComboBox.getSelectionModel().clearSelection();
        }
    }
}
