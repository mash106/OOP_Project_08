package org.example.practice;

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

public class EmployeeDatabaseController {

    @FXML
    private TableView<Employee> employeeTableView;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> jobTitleColumn;

    @FXML
    private void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));


        employeeTableView.setItems(employeeData);
    }


    private ObservableList<Employee> employeeData = FXCollections.observableArrayList(
            new Employee(1, "John Doe", "Manager"),
            new Employee(2, "Jane Smith", "Technician"),
            new Employee(3, "Bob Johnson", "Worker"),
            new Employee(4, "Alice Brown", "Accountant"),
            new Employee(5, "Charlie Davis", "Supervisor"),
            new Employee(6, "Emma Wilson", "Secretary"),
            new Employee(7, "David Lee", "Technician"),
            new Employee(8, "Sophia White", "HR Specialist"),
            new Employee(9, "James Green", "Engineer"),
            new Employee(10, "Olivia Harris", "Manager"),
            new Employee(11, "Liam Clark", "Technician"),
            new Employee(12, "Mia Lewis", "Worker"),
            new Employee(13, "Noah Walker", "Supervisor"),
            new Employee(14, "Amelia Hall", "Secretary"),
            new Employee(15, "Ethan Allen", "Engineer")
    );

    @FXML
    private void addEmployee(ActionEvent event) {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add New Employee");
        dialog.setHeaderText("Enter new employee details (format: ID, Name, JobTitle)");
        dialog.setContentText("Details:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(details -> {
            try {
                String[] parts = details.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String jobTitle = parts[2].trim();
                // Check if ID is unique before adding
                if (employeeData.stream().noneMatch(e -> e.getId() == id)) {
                    employeeData.add(new Employee(id, name, jobTitle));
                } else {
                    showAlert("Duplicate ID", "Employee with this ID already exists.");
                }
            } catch (Exception e) {
                showAlert("Error", "Invalid input format. Please enter details as ID, Name, JobTitle.");
            }
        });
    }

    @FXML
    private void editEmployee(ActionEvent event) {
        Employee selectedEmployee = employeeTableView.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            TextInputDialog dialog = new TextInputDialog(selectedEmployee.getName() + ", " + selectedEmployee.getJobTitle());
            dialog.setTitle("Edit Employee");
            dialog.setHeaderText("Edit employee details (format: Name, JobTitle)");
            dialog.setContentText("Details:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(details -> {
                try {
                    String[] parts = details.split(",");
                    selectedEmployee.setName(parts[0].trim());
                    selectedEmployee.setJobTitle(parts[1].trim());
                    employeeTableView.refresh();
                } catch (Exception e) {
                    showAlert("Error", "Invalid input format. Please enter details as Name, JobTitle.");
                }
            });
        } else {
            showAlert("No Selection", "Please select an employee to edit.");
        }
    }

    @FXML
    private void deleteEmployee(ActionEvent event) {
        Employee selectedEmployee = employeeTableView.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Employee");
            alert.setHeaderText("Are you sure you want to delete this employee?");
            alert.setContentText("ID: " + selectedEmployee.getId() + ", Name: " + selectedEmployee.getName());

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
}
