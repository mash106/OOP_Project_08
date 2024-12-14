package com.example.oop_project_group_8.org.example.practice.practice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class EmployeeOnboardingTrackerController {

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, Integer> employeeIdColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> jobPositionColumn;

    @FXML
    private TableColumn<Employee, String> departmentColumn;

    private ObservableList<Employee> employeeData = FXCollections.observableArrayList(
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
    private void initialize() {

        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        jobPositionColumn.setCellValueFactory(new PropertyValueFactory<>("jobPosition"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));


        employeeTable.setItems(employeeData);
    }

    @FXML
    private void editEmployee(ActionEvent event) {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            TextInputDialog dialog = new TextInputDialog(selectedEmployee.getName() + ", " +
                    selectedEmployee.getJobPosition() + ", " + selectedEmployee.getDepartment());
            dialog.setTitle("Edit Employee");
            dialog.setHeaderText("Edit employee details (format: Name, Job Position, Department)");
            dialog.setContentText("Details:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(details -> {
                try {
                    String[] parts = details.split(",");
                    selectedEmployee.setName(parts[0].trim());
                    selectedEmployee.setJobPosition(parts[1].trim());
                    selectedEmployee.setDepartment(parts[2].trim());
                    employeeTable.refresh();
                } catch (Exception e) {
                    showAlert("Error", "Invalid input format. Please enter details as Name, Job Position, Department.");
                }
            });
        } else {
            showAlert("No Selection", "Please select an employee to edit.");
        }
    }

    @FXML
    private void deleteEmployee(ActionEvent event) {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Employee");
            alert.setHeaderText("Are you sure you want to delete this employee?");
            alert.setContentText("ID: " + selectedEmployee.getEmployeeId() + ", Name: " + selectedEmployee.getName());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                employeeData.remove(selectedEmployee);
            }
        } else {
            showAlert("No Selection", "Please select an employee to delete.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public class Employee {
        private final Integer employeeId;
        private String name;
        private String jobPosition;
        private String department;

        public Employee(int employeeId, String name, String jobPosition, String department) {
            this.employeeId = employeeId;
            this.name = name;
            this.jobPosition = jobPosition;
            this.department = department;
        }

        public Integer getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJobPosition() {
            return jobPosition;
        }

        public void setJobPosition(String jobPosition) {
            this.jobPosition = jobPosition;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }
    }
}
