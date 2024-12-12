package com.example.ms1group8;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EquipmentManagementController {

    @FXML
    private TableView<Equipment> equipmentTable;
    @FXML
    private TableColumn<Equipment, String> equipmentColumn;
    @FXML
    private TableColumn<Equipment, String> statusColumn;
    @FXML
    private TableColumn<Equipment, String> lastMaintainedColumn;
    @FXML
    private TextArea malfunctionNotesArea;
    @FXML
    private Button scheduleMaintBtn;
    @FXML
    private Button logMalfunctionBtn;

    private final ObservableList<Equipment> equipmentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize the columns of the equipment table
        equipmentColumn.setCellValueFactory(cellData -> cellData.getValue().equipmentNameProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        lastMaintainedColumn.setCellValueFactory(cellData -> cellData.getValue().lastMaintainedProperty());

        // Add some sample equipment for demonstration
        equipmentList.add(new Equipment("Generator", "Operational", "2024-01-15"));
        equipmentList.add(new Equipment("Air Compressor", "Under Maintenance", "2024-03-10"));
        equipmentList.add(new Equipment("Forklift", "Operational", "2024-02-05"));
        equipmentList.add(new Equipment("Conveyor Belt", "Operational", "2024-04-20"));
        equipmentList.add(new Equipment("Water Pump", "Malfunctioning", "2024-05-01"));
        equipmentList.add(new Equipment("Welding Machine", "Operational", "2024-06-18"));

        equipmentTable.setItems(equipmentList);
    }

    @FXML
    public void handleScheduleMaintenance(ActionEvent actionEvent) {
        // Handle scheduling maintenance
        Equipment selectedEquipment = equipmentTable.getSelectionModel().getSelectedItem();
        if (selectedEquipment == null) {
            showAlert("No Equipment Selected", "Please select an equipment item to schedule maintenance.");
        } else {
            // Update the status to "Under Maintenance" and set the last maintenance date
            selectedEquipment.setStatus("Under Maintenance");
            selectedEquipment.setLastMaintained("Scheduled for " + getCurrentDate());
            showAlert("Maintenance Scheduled", "Maintenance has been scheduled for " + selectedEquipment.getEquipmentName() + ".");
        }
    }

    @FXML
    public void handleLogMalfunction(ActionEvent actionEvent) {
        // Handle logging equipment malfunction
        Equipment selectedEquipment = equipmentTable.getSelectionModel().getSelectedItem();
        String malfunctionNotes = malfunctionNotesArea.getText();
        if (selectedEquipment == null) {
            showAlert("No Equipment Selected", "Please select an equipment item to log malfunction.");
        } else if (malfunctionNotes.isEmpty()) {
            showAlert("Malfunction Notes Missing", "Please enter malfunction details.");
        } else {
            // Update the equipment status to "Malfunctioning"
            selectedEquipment.setStatus("Malfunctioning");
            showAlert("Malfunction Logged", "Malfunction for " + selectedEquipment.getEquipmentName() + " has been logged.");
        }
    }

    private String getCurrentDate() {
        // This method can be used to get the current system date (you can use any date format here)
        return java.time.LocalDate.now().toString();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Equipment class to represent equipment data
    public static class Equipment {
        private final StringProperty equipmentName;
        private final StringProperty status;
        private final StringProperty lastMaintained;

        public Equipment(String equipmentName, String status, String lastMaintained) {
            this.equipmentName = new SimpleStringProperty(equipmentName);
            this.status = new SimpleStringProperty(status);
            this.lastMaintained = new SimpleStringProperty(lastMaintained);
        }

        public StringProperty equipmentNameProperty() {
            return equipmentName;
        }

        public StringProperty statusProperty() {
            return status;
        }

        public StringProperty lastMaintainedProperty() {
            return lastMaintained;
        }

        public String getEquipmentName() {
            return equipmentName.get();
        }

        public void setEquipmentName(String equipmentName) {
            this.equipmentName.set(equipmentName);
        }

        public String getStatus() {
            return status.get();
        }

        public void setStatus(String status) {
            this.status.set(status);
        }

        public String getLastMaintained() {
            return lastMaintained.get();
        }

        public void setLastMaintained(String lastMaintained) {
            this.lastMaintained.set(lastMaintained);
        }
    }
}
