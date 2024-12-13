package org.example.practice;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class FeedbackController {


    @FXML
    private Slider satisfactionSlider;

    @FXML
    private TextArea feedbackArea;

    @FXML
    private Button submitFeedbackButton;


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


    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
