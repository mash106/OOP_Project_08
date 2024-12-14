package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ContactSupportSceneController {

    @javafx.fxml.FXML
    private ComboBox<String> supportIssueComboBox;

    @javafx.fxml.FXML
    private TextArea supportMessageTextArea;

    @javafx.fxml.FXML
    private TextField customerSupportnameField;

    @javafx.fxml.FXML
    private TextField customerSupportemailField;

    @javafx.fxml.FXML
    public void initialize() {
        supportIssueComboBox.getItems().addAll(
                "Billing Issue",
                "Technical Support",
                "Product Inquiry",
                "Refund Request",
                "Other"
        );
    }

    @javafx.fxml.FXML
    public void submitSupportTicketButtonOnClicked(ActionEvent actionEvent) {
        String selectedIssue = supportIssueComboBox.getSelectionModel().getSelectedItem();
        if (selectedIssue == null) {
            showAlert("Error", "No Issue Selected", "Please select an issue type.", Alert.AlertType.ERROR);
            return;
        }

        String customerName = customerSupportnameField.getText().trim();
        if (customerName.isEmpty()) {
            showAlert("Error", "Name Required", "Please enter your name.", Alert.AlertType.ERROR);
            return;
        }

        String customerEmail = customerSupportemailField.getText().trim();
        if (customerEmail.isEmpty() || !customerEmail.contains("@")) {
            showAlert("Error", "Valid Email Required", "Please enter a valid email address.", Alert.AlertType.ERROR);
            return;
        }

        String supportMessage = supportMessageTextArea.getText().trim();
        if (supportMessage.isEmpty()) {
            showAlert("Error", "Message Required", "Please describe your problem.", Alert.AlertType.ERROR);
            return;
        }

        boolean isSuccess = saveSupportTicketToFile(customerName, customerEmail, selectedIssue, supportMessage);

        if (isSuccess) {
            showAlert("Success", "Ticket Submitted", "Your support ticket has been successfully submitted.", Alert.AlertType.INFORMATION);
            clearFields();
        } else {
            showAlert("Error", "Submission Failed", "There was an error submitting your support ticket. Please try again.", Alert.AlertType.ERROR);
        }
    }

    private boolean saveSupportTicketToFile(String name, String email, String issueType, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CustomerComplain.txt", true))) {
            writer.write("--- Support Ticket ---\n");
            writer.write("Date/Time: " + LocalDateTime.now() + "\n");
            writer.write("Name: " + name + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Issue Type: " + issueType + "\n");
            writer.write("Message: \n" + message + "\n");
            writer.write("---------------------\n\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void clearFields() {
        supportIssueComboBox.getSelectionModel().clearSelection();
        customerSupportnameField.clear();
        customerSupportemailField.clear();
        supportMessageTextArea.clear();
    }

    private void showAlert(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backButtonOnClicked(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("customerDashboardScene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
