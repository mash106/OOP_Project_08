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


    private void switchScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/practice/" + fxmlFile));
            AnchorPane newRoot = loader.load();

            Stage currentStage = (Stage) customerInquiryButton.getScene().getWindow();

            currentStage.setScene(new Scene(newRoot));
            currentStage.setTitle(fxmlFile.replace(".fxml", "").replace("FAQDatabaseAccess", "FAQ Database Access"));
        } catch (IOException e) {
            e.printStackTrace();
            showErrorAlert("Error", "Failed to load the file: " + fxmlFile + "\nPlease ensure it is placed correctly.");
        }
    }


    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
