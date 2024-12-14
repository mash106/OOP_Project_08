package org.example.practice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerServiceRepresentative {

    @FXML
    private Button customerInquiryButton;

    @FXML
    private Button orderTrackingButton;

    @FXML
    private Button feedbackCollectionButton;

    @FXML
    private Button faqDatabaseButton;

    @FXML
    private Button appointmentSchedulingButton;

    @FXML
    private Button productInfoButton;

    @FXML
    private Button serviceRequestButton;

    @FXML
    private Button customerProfileButton;

    @FXML
    public void initialize() {
        customerInquiryButton.setOnAction(event -> switchScene("CustomerInquiryManagement.fxml"));
        orderTrackingButton.setOnAction(event -> switchScene("OrderTrackingSystem.fxml"));
        feedbackCollectionButton.setOnAction(event -> switchScene("FeedbackCollectionForm.fxml"));
        faqDatabaseButton.setOnAction(event -> switchScene("FAQDatabaseAccess.fxml")); // Updated
        appointmentSchedulingButton.setOnAction(event -> switchScene("AppointmentSchedulingSystem.fxml"));
        productInfoButton.setOnAction(event -> switchScene("ProductInformationLookup.fxml"));
        serviceRequestButton.setOnAction(event -> switchScene("ServiceRequestTicketing.fxml"));
        customerProfileButton.setOnAction(event -> switchScene("CustomerProfileManagement.fxml"));
    }

    /**
     * Helper method to switch scenes to the specified FXML file.
     *
     * @param fxmlFile The name of the FXML file to load.
     */
    private void switchScene(String fxmlFile) {
        try {
            // Ensure the file exists and load it
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/practice/" + fxmlFile));
            AnchorPane newRoot = loader.load();

            // Get the current stage from any button's scene
            Stage currentStage = (Stage) customerInquiryButton.getScene().getWindow();

            // Set the new scene to the stage
            currentStage.setScene(new Scene(newRoot));
            currentStage.setTitle(fxmlFile.replace(".fxml", "").replace("FAQDatabaseAccess", "FAQ Database Access"));
        } catch (IOException e) {
            e.printStackTrace();
            // Display an alert if there is an error loading the FXML file
            showErrorAlert("Error", "Failed to load the file: " + fxmlFile + "\nPlease ensure it is placed correctly.");
        }
    }

    /**
     * Displays an error alert dialog.
     *
     * @param title   The title of the alert dialog.
     * @param message The content message of the alert dialog.
     */
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
