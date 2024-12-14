package com.example.oop_project_group_8.org.example.practice.practice;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ServiceRequestController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField contactField;

    @FXML
    private TextArea issueDescriptionArea;

    @FXML
    private Label ticketNumberLabel;

    @FXML
    private Button submitRequestButton;

    @FXML
    public void initialize() {

        submitRequestButton.setOnAction(event -> submitServiceRequest());
    }

    private void submitServiceRequest() {
        String name = nameField.getText();
        String contact = contactField.getText();
        String issueDescription = issueDescriptionArea.getText();


        if (name.trim().isEmpty() || contact.trim().isEmpty() || issueDescription.trim().isEmpty()) {
            showAlert("Error", "All fields must be filled out.");
        } else {

            String ticketNumber = generateTicketNumber();
            ticketNumberLabel.setText("Ticket Number: " + ticketNumber);


            showAlert("Success", "Your service request has been submitted successfully.");
        }
    }


    private String generateTicketNumber() {
        return "SR" + System.currentTimeMillis();
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
