package com.example.oop_project_group_8.ms1group8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import java.io.IOException;

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
    private final ObservableList<String> fishSpeciesList = FXCollections.observableArrayList(
            "Tilapia", "Catfish", "Salmon", "Ruhu", "Carp", "Pangasius", "Catla", "Grass Carp");
    private final ObservableList<String> appetiteLevels = FXCollections.observableArrayList("Normal", "Decreased", "Increased");

    @FXML
    public void initialize() {
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

    public Button getSubmitHealthAssessmentBtn() {
        return submitHealthAssessmentBtn;
    }

    public void setSubmitHealthAssessmentBtn(Button submitHealthAssessmentBtn) {
        this.submitHealthAssessmentBtn = submitHealthAssessmentBtn;
    }
}
