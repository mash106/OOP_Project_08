package com.example.oop_project_group_8.org.example.practice.practice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedbackController {

    @FXML
    private Slider satisfactionSlider;

    @FXML
    private TextArea feedbackArea;

    @FXML
    private Button submitFeedbackButton;

    @FXML
    private Button backButton;

    @FXML
    private void submitFeedback() {
        int satisfactionRating = (int) satisfactionSlider.getValue();
        String feedbackText = feedbackArea.getText();

        if (feedbackText.trim().isEmpty()) {
            showAlert(AlertType.WARNING, "Feedback Incomplete", "Please provide detailed feedback.");
            return;
        }

        showAlert(AlertType.INFORMATION, "Feedback Submitted",
                "Your satisfaction rating: " + satisfactionRating + "\n" +
                        "Feedback: " + feedbackText);
    }

    @FXML
    private void handleBackAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerserviceRepresentative.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Customer Service Representative");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Failed to load the previous scene.");
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
