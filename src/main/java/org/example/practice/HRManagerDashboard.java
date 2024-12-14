package org.example.practice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HRManagerDashboard {

    @FXML
    private Button employeeDatabaseButton;

    @FXML
    private Button attendanceTrackingButton;

    @FXML
    private Button payrollProcessingButton;

    @FXML
    private Button leaveManagementButton;

    @FXML
    private Button performanceEvaluationButton;

    @FXML
    private Button trainingScheduleButton;

    @FXML
    private Button onboardingTrackerButton;

    @FXML
    private Button benefitsAdministrationButton;

    @FXML
    public void initialize() {
        // Add button actions to switch scenes
        employeeDatabaseButton.setOnAction(event -> switchScene(event, "EmployeeDatabaseManagement.fxml"));
        attendanceTrackingButton.setOnAction(event -> switchScene(event, "AttendanceTracking.fxml"));
        payrollProcessingButton.setOnAction(event -> switchScene(event, "PayrollProcessing.fxml"));
        leaveManagementButton.setOnAction(event -> switchScene(event, "LeaveManagement.fxml"));
        performanceEvaluationButton.setOnAction(event -> switchScene(event, "PerformanceEvaluation.fxml"));
        trainingScheduleButton.setOnAction(event -> switchScene(event, "TrainingScheduleManagement.fxml"));
        onboardingTrackerButton.setOnAction(event -> switchScene(event, "EmployeeOnboardingTracker.fxml"));
        benefitsAdministrationButton.setOnAction(event -> switchScene(event, "BenefitsAdministration.fxml"));
    }

    /**
     * Switches the scene to a new FXML file.
     *
     * @param event    The button click event.
     * @param fxmlFile The FXML file to load.
     */
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Update the title of the stage
            stage.setTitle("HR Manager - " + fxmlFile.replace(".fxml", ""));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading scene: " + fxmlFile);
        }
    }
}
