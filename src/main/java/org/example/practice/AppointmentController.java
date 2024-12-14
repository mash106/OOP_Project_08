package org.example.practice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AppointmentController {

    @FXML
    private ComboBox<String> serviceComboBox;

    @FXML
    private DatePicker appointmentDatePicker;

    @FXML
    private ComboBox<String> timeSlotComboBox;

    @FXML
    private Label confirmationLabel;

    @FXML
    private Button scheduleAppointmentButton;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {

        ObservableList<String> services = FXCollections.observableArrayList(
                "Fish Breeding Consultation",
                "Water Quality Analysis",
                "Hatchery Maintenance Guidance",
                "Disease Diagnosis",
                "Feeding Strategy Planning"
        );
        serviceComboBox.setItems(services);

        ObservableList<String> timeSlots = FXCollections.observableArrayList(
                "09:00 AM - 10:00 AM",
                "10:30 AM - 11:30 AM",
                "12:00 PM - 01:00 PM",
                "02:00 PM - 03:00 PM",
                "03:30 PM - 04:30 PM"
        );
        timeSlotComboBox.setItems(timeSlots);

        scheduleAppointmentButton.setOnAction(event -> scheduleAppointment());
        backButton.setOnAction(event -> goBackToCustomerService());
    }

    private void scheduleAppointment() {
        String selectedService = serviceComboBox.getValue();
        LocalDate selectedDate = appointmentDatePicker.getValue();
        String selectedTimeSlot = timeSlotComboBox.getValue();

        if (selectedService == null || selectedDate == null || selectedTimeSlot == null) {
            confirmationLabel.setText("Please select a service, date, and time slot.");
            confirmationLabel.setStyle("-fx-text-fill: red;");
        } else {
            confirmationLabel.setText(String.format(
                    "Appointment scheduled:\nService: %s\nDate: %s\nTime: %s",
                    selectedService, selectedDate, selectedTimeSlot
            ));
            confirmationLabel.setStyle("-fx-text-fill: green;");
        }
    }

    private void goBackToCustomerService() {
        try {
            // Load the "CustomerserviceRepresentative.fxml" scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerserviceRepresentative.fxml"));
            Parent root = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Customer Service Representative");
        } catch (IOException e) {
            e.printStackTrace();
            confirmationLabel.setText("Failed to load the previous scene.");
            confirmationLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
