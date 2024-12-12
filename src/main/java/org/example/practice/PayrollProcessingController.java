package org.example.practice;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PayrollProcessingController {
    @javafx.fxml.FXML
    private TableColumn baseSalaryColumn;
    @javafx.fxml.FXML
    private TableColumn bonusColumn;
    @javafx.fxml.FXML
    private TableColumn nameColumn;
    @javafx.fxml.FXML
    private ComboBox payPeriodComboBox;
    @javafx.fxml.FXML
    private TableView payrollTableView;
    @javafx.fxml.FXML
    private TableColumn employeeIdColumn;
    @javafx.fxml.FXML
    private Button processPayrollButton;
    @javafx.fxml.FXML
    private TableColumn totalSalaryColumn;
}
