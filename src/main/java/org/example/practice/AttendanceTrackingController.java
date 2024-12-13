package org.example.practice;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

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

    private final ObservableList<EmployeeAttendance> attendanceData = FXCollections.observableArrayList();

    private final ObservableList<Employee> employeeData = FXCollections.observableArrayList(
            new Employee(1, "Alice Brown", "Manager", "Operations"),
            new Employee(2, "David Smith", "Technician", "Maintenance"),
            new Employee(3, "Emma Jones", "Assistant", "HR"),
            new Employee(4, "Sophia White", "Manager", "Sales"),
            new Employee(5, "Liam Johnson", "Technician", "Maintenance"),
            new Employee(6, "Olivia Williams", "HR Specialist", "HR"),
            new Employee(7, "Mason Davis", "Engineer", "IT"),
            new Employee(8, "Isabella Garcia", "Manager", "Operations"),
            new Employee(9, "Noah Martinez", "Worker", "Production"),
            new Employee(10, "Lucas Wilson", "Supervisor", "Logistics"),
            new Employee(11, "Amelia Moore", "Technician", "Maintenance"),
            new Employee(12, "Elijah Taylor", "Assistant", "Customer Service"),
            new Employee(13, "Harper Anderson", "Technician", "Maintenance"),
            new Employee(14, "Ethan Thomas", "Manager", "Finance"),
            new Employee(15, "Avery Jackson", "Engineer", "R&D"),
            new Employee(16, "Jack White", "Assistant", "Operations"),
            new Employee(17, "Madison Harris", "Technician", "Maintenance"),
            new Employee(18, "Benjamin Clark", "HR Specialist", "HR"),
            new Employee(19, "Charlotte Hall", "Supervisor", "HR"),
            new Employee(20, "James Allen", "Worker", "Manufacturing")
    );

    @FXML
    public void initialize() {
        employeeIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().employeeNameProperty());
        attendanceStatusColumn.setCellValueFactory(cellData -> cellData.getValue().attendanceStatusProperty());

        attendanceActionColumn.setCellFactory(new Callback<>() {
            @Override
            public javafx.scene.control.TableCell<EmployeeAttendance, HBox> call(TableColumn<EmployeeAttendance, HBox> param) {
                return new javafx.scene.control.TableCell<>() {
                    @Override
                    protected void updateItem(HBox item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            EmployeeAttendance attendance = getTableRow().getItem();
                            if (attendance != null) {
                                setGraphic(attendance.createActionButtons());
                            }
                        }
                    }
                };
            }
        });

        for (Employee employee : employeeData) {
            attendanceData.add(new EmployeeAttendance(employee, "Pending"));
        }

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
        private final Employee employee;
        private final StringProperty attendanceStatus;
        private final HBox actionButtons;

        public EmployeeAttendance(Employee employee, String attendanceStatus) {
            this.employee = employee;
            this.attendanceStatus = new SimpleStringProperty(attendanceStatus);
            this.actionButtons = createActionButtons();
        }

        public StringProperty employeeIdProperty() {
            return new SimpleStringProperty(String.valueOf(employee.getEmployeeId()));
        }

        public StringProperty employeeNameProperty() {
            return new SimpleStringProperty(employee.getEmployeeName());
        }

        public StringProperty attendanceStatusProperty() {
            return attendanceStatus;
        }

        public String getAttendanceStatus() {
            return attendanceStatus.get();
        }

        public void setAttendanceStatus(String status) {
            this.attendanceStatus.set(status);
        }

        public HBox createActionButtons() {
            Button presentButton = new Button("Present");
            presentButton.setOnAction(event -> setAttendanceStatus("Present"));

            Button absentButton = new Button("Absent");
            absentButton.setOnAction(event -> setAttendanceStatus("Absent"));

            return new HBox(10, presentButton, absentButton);
        }
    }

    public static class Employee {
        private final int employeeId;
        private final String employeeName;

        public Employee(int employeeId, String employeeName, String role, String department) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }
    }
}
