package com.example.oop_project_group_8.org.example.practice.practice;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class AttendanceTrackingController {

    @FXML
    private DatePicker attendanceDatePicker;

    @FXML
    private TableView<EmployeeAttendance> attendanceTableView;

    @FXML
    private TableColumn<EmployeeAttendance, String> employeeIdColumn;

    @FXML
    private TableColumn<EmployeeAttendance, String> nameColumn;

    @FXML
    private TableColumn<EmployeeAttendance, String> attendanceStatusColumn;

    @FXML
    private TableColumn<EmployeeAttendance, HBox> attendanceActionColumn;

    @FXML
    private Button saveAttendanceButton;

    private ObservableList<EmployeeAttendance> attendanceData;

    @FXML
    public void initialize() {
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        attendanceStatusColumn.setCellValueFactory(new PropertyValueFactory<>("attendanceStatus"));
        attendanceActionColumn.setCellValueFactory(new PropertyValueFactory<>("actionButtons"));

        attendanceData = FXCollections.observableArrayList(
                new EmployeeAttendance("1", "Alice Brown"),
                new EmployeeAttendance("2", "David Smith"),
                new EmployeeAttendance("3", "Emma Jones"),
                new EmployeeAttendance("4", "Sophia White"),
                new EmployeeAttendance("5", "Liam Johnson"),
                new EmployeeAttendance("6", "Olivia Williams"),
                new EmployeeAttendance("7", "Mason Davis"),
                new EmployeeAttendance("8", "Isabella Garcia"),
                new EmployeeAttendance("9", "Noah Martinez"),
                new EmployeeAttendance("10", "Lucas Wilson")
        );

        attendanceTableView.setItems(attendanceData);

        saveAttendanceButton.setOnAction(event -> saveAttendance());
    }

    private void saveAttendance() {
        if (attendanceDatePicker.getValue() != null) {
            String selectedDate = attendanceDatePicker.getValue().toString();
            System.out.println("Attendance saved for date: " + selectedDate);

            for (EmployeeAttendance attendance : attendanceData) {
                System.out.println("Employee ID: " + attendance.getEmployeeId() +
                        ", Name: " + attendance.getEmployeeName() +
                        ", Status: " + attendance.getAttendanceStatus());
            }
        } else {
            System.out.println("Please select a date.");
        }
    }

    public static class EmployeeAttendance {
        private final StringProperty employeeId;
        private final StringProperty employeeName;
        private final StringProperty attendanceStatus;
        private final HBox actionButtons;

        public EmployeeAttendance(String employeeId, String employeeName) {
            this.employeeId = new SimpleStringProperty(employeeId);
            this.employeeName = new SimpleStringProperty(employeeName);
            this.attendanceStatus = new SimpleStringProperty("Pending");
            this.actionButtons = createActionButtons();
        }

        public String getEmployeeId() {
            return employeeId.get();
        }

        public StringProperty employeeIdProperty() {
            return employeeId;
        }

        public String getEmployeeName() {
            return employeeName.get();
        }

        public StringProperty employeeNameProperty() {
            return employeeName;
        }

        public String getAttendanceStatus() {
            return attendanceStatus.get();
        }

        public StringProperty attendanceStatusProperty() {
            return attendanceStatus;
        }

        public void setAttendanceStatus(String status) {
            attendanceStatus.set(status);
        }

        public HBox getActionButtons() {
            return actionButtons;
        }

        private HBox createActionButtons() {
            Button presentButton = new Button("Present");
            presentButton.setOnAction(e -> setAttendanceStatus("Present"));

            Button absentButton = new Button("Absent");
            absentButton.setOnAction(e -> setAttendanceStatus("Absent"));

            return new HBox(10, presentButton, absentButton);
        }
    }
}
