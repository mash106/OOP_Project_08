package com.example.oop_project_group_8.org.example.practice.practice;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LeaveManagementController {

    @FXML
    private ComboBox<String> employeeComboBox;

    @FXML
    private TableView<LeaveRequest> leaveTableView;

    @FXML
    private TableColumn<LeaveRequest, String> leaveTypeColumn;

    @FXML
    private TableColumn<LeaveRequest, String> startDateColumn;

    @FXML
    private TableColumn<LeaveRequest, String> endDateColumn;

    @FXML
    private TableColumn<LeaveRequest, String> statusColumn;

    @FXML
    private Button applyLeaveButton;

    @FXML
    private Button approveButton;

    @FXML
    private Button rejectButton;

    @FXML
    private Label nameLabelFxid;

    private ObservableList<String> employeeList;
    private ObservableList<LeaveRequest> leaveRequestsList;


    @FXML
    public void initialize() {

        employeeList = FXCollections.observableArrayList("John Doe", "Jane Smith", "Tom Brown", "Alice Brown", "Bob White", "Charlie Green", "David Black", "Taskin Forsh", "label broker");
        employeeComboBox.setItems(employeeList);


        leaveTypeColumn.setCellValueFactory(cellData -> cellData.getValue().leaveTypeProperty());
        startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
        endDateColumn.setCellValueFactory(cellData -> cellData.getValue().endDateProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());


        leaveRequestsList = FXCollections.observableArrayList(
                new LeaveRequest("Sick Leave", "2024-12-01", "2024-12-05", "Pending"),
                new LeaveRequest("Vacation", "2024-12-10", "2024-12-20", "Pending")
        );

        leaveTableView.setItems(leaveRequestsList);
    }


    @FXML
    private void applyLeaveButton() {
        String selectedEmployee = employeeComboBox.getValue();
        if (selectedEmployee == null) {
            showAlert(AlertType.WARNING, "Warning", "Please select an employee.");
            return;
        }


        showAlert(AlertType.INFORMATION, "Leave Application", selectedEmployee + "'s leave has been applied successfully.");
    }


    @FXML
    private void approveButton() {
        LeaveRequest selectedLeaveRequest = leaveTableView.getSelectionModel().getSelectedItem();
        if (selectedLeaveRequest == null) {
            showAlert(AlertType.WARNING, "Warning", "Please select a leave request to approve.");
            return;
        }


        selectedLeaveRequest.setStatus("Approved");
        leaveTableView.refresh(); // Refresh the table to show updated status

        showAlert(AlertType.INFORMATION, "Leave Approved", "The leave request for " + selectedLeaveRequest.getLeaveType() + " has been approved.");
    }


    @FXML
    private void approveRejectButton() {
        LeaveRequest selectedLeaveRequest = leaveTableView.getSelectionModel().getSelectedItem();
        if (selectedLeaveRequest == null) {
            showAlert(AlertType.WARNING, "Warning", "Please select a leave request to reject.");
            return;
        }


        selectedLeaveRequest.setStatus("Rejected");
        leaveTableView.refresh();

        showAlert(AlertType.INFORMATION, "Leave Rejected", "The leave request for " + selectedLeaveRequest.getLeaveType() + " has been rejected.");
    }


    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    private void updateEmployeeName() {
        String selectedEmployee = employeeComboBox.getValue();
        if (selectedEmployee != null) {
            nameLabelFxid.setText("Selected Employee: " + selectedEmployee);
        }
    }


    public static class LeaveRequest {
        private final javafx.beans.property.SimpleStringProperty leaveType;
        private final javafx.beans.property.SimpleStringProperty startDate;
        private final javafx.beans.property.SimpleStringProperty endDate;
        private final javafx.beans.property.SimpleStringProperty status;

        public LeaveRequest(String leaveType, String startDate, String endDate, String status) {
            this.leaveType = new javafx.beans.property.SimpleStringProperty(leaveType);
            this.startDate = new javafx.beans.property.SimpleStringProperty(startDate);
            this.endDate = new javafx.beans.property.SimpleStringProperty(endDate);
            this.status = new javafx.beans.property.SimpleStringProperty(status);
        }

        public String getLeaveType() {
            return leaveType.get();
        }

        public javafx.beans.property.StringProperty leaveTypeProperty() {
            return leaveType;
        }

        public String getStartDate() {
            return startDate.get();
        }

        public javafx.beans.property.StringProperty startDateProperty() {
            return startDate;
        }

        public String getEndDate() {
            return endDate.get();
        }

        public javafx.beans.property.StringProperty endDateProperty() {
            return endDate;
        }

        public String getStatus() {
            return status.get();
        }

        public javafx.beans.property.StringProperty statusProperty() {
            return status;
        }

        public void setStatus(String status) {
            this.status.set(status);
        }
    }
}
