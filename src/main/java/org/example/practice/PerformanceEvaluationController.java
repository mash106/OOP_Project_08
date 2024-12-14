package org.example.practice;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class PerformanceEvaluationController {

    @FXML
    private ComboBox<String> employeeSelector;

    @FXML
    private TextArea evaluationForm;

    @FXML
    private Button saveEvaluationButton;

    @FXML
    private Button archiveEvaluationButton;


    @FXML
    public void initialize() {

        employeeSelector.getItems().addAll("John", "Jane", "Bob", "Alice", "Charlie", "Emma", "David", "Sophia", "James", "Olivia", "Liam", "Mia", "Noah", "Amelia", "Ethan");

    }


    @FXML
    private void handleSaveEvaluation() {
        String selectedEmployee = employeeSelector.getValue();
        String evaluationDetails = evaluationForm.getText();

        if (selectedEmployee == null || selectedEmployee.isEmpty() || evaluationDetails.isEmpty()) {
            showAlert("Error", "Please fill in all fields before saving the evaluation.");
        } else {

            showAlert("Success", "Evaluation saved successfully for " + selectedEmployee);
        }
    }


    @FXML
    private void handleArchiveEvaluation() {
        String selectedEmployee = employeeSelector.getValue();
        String evaluationDetails = evaluationForm.getText();

        if (selectedEmployee == null || selectedEmployee.isEmpty() || evaluationDetails.isEmpty()) {
            showAlert("Error", "Please fill in all fields before archiving the evaluation.");
        } else {

            showAlert("Success", "Evaluation archived for " + selectedEmployee);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
