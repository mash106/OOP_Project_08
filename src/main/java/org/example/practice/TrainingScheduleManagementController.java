package org.example.practice;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class TrainingScheduleManagementController {

    @FXML
    private TextField trainingProgramName;

    @FXML
    private DatePicker trainingDate;

    @FXML
    private TableView<?> employeeTrainingTable;

    @FXML
    private TableColumn<?, ?> employeeIdColumn;
    @FXML
    private TableColumn<?, ?> employeeNameColumn;
    @FXML
    private TableColumn<?, ?> trainingStatusColumn;

    @FXML
    private Button createTrainingProgramButton;

    @FXML
    private Button sendNotificationsButton;

    @FXML
    public void initialize() {
        createTrainingProgramButton.setOnAction(event -> createTrainingProgram());
        sendNotificationsButton.setOnAction(event -> sendNotifications());
    }

    @FXML
    private void createTrainingProgram() {
        String programName = trainingProgramName.getText();
        String trainingDateStr = trainingDate.getValue() != null ? trainingDate.getValue().toString() : "Not selected";

        if (programName.trim().isEmpty()) {
            showAlert("Error", "Training Program Name cannot be empty.");
        } else {

            showAlert("Success", "Training Program '" + programName + "' created for " + trainingDateStr);
        }
    }

    @FXML
    private void sendNotifications() {

        showAlert("Success", "Notifications sent to employees.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
