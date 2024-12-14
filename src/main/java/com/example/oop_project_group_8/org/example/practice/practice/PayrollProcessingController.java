package com.example.oop_project_group_8.org.example.practice.practice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class PayrollProcessingController {

    @FXML
    private ComboBox<String> payPeriodComboBox;

    @FXML
    private TableView<Employee> payrollTableView;

    @FXML
    private TableColumn<Employee, String> employeeIdColumn;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Double> baseSalaryColumn;
    @FXML
    private TableColumn<Employee, Double> bonusColumn;
    @FXML
    private TableColumn<Employee, Double> totalSalaryColumn;

    @FXML
    private Button processPayrollButton;

    private ObservableList<Employee> employeeList;


    @FXML
    public void initialize() {

        payPeriodComboBox.setItems(FXCollections.observableArrayList("January 2024", "February 2024", "March 2024", "April 2024", "May 2024", "June 2024", "July 2024" , "August 2024", "September 2024",  "OCtobar 2024", "Novembar 2024"));


        employeeIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployeeId()));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        baseSalaryColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getBaseSalary()).asObject());
        bonusColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getBonus()).asObject());
        totalSalaryColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotalSalary()).asObject());


        employeeList = FXCollections.observableArrayList(
                new Employee("E001", "John Doe", 5000, 500),
                new Employee("E002", "Jane Smith", 6000, 600),
                new Employee("E003", "Alice Brown", 7000, 700),
                new Employee("E004", "Bob White", 5500, 550),
                new Employee("E005", "Charlie Green", 4500, 450),
                new Employee("E006", "David Black", 6500, 650)
        );

        payrollTableView.setItems(employeeList);
    }


    @FXML
    private void handleProcessPayroll() {
        String selectedPayPeriod = payPeriodComboBox.getValue();

        if (selectedPayPeriod == null) {
            showAlert("Error", "Please select a pay period before processing payroll.");
            return;
        }


        for (Employee employee : employeeList) {
            employee.calculateTotalSalary();
        }


        showAlert("Success", "Payroll processed successfully for " + selectedPayPeriod);
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public static class Employee {
        private String employeeId;
        private String name;
        private double baseSalary;
        private double bonus;

        public Employee(String employeeId, String name, double baseSalary, double bonus) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
            this.bonus = bonus;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public double getBonus() {
            return bonus;
        }

        public double getTotalSalary() {
            return baseSalary + bonus;
        }


        public void calculateTotalSalary() {

        }
    }
}
