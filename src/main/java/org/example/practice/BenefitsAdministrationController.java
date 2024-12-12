package org.example.practice;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BenefitsAdministrationController {
    @javafx.fxml.FXML
    private ComboBox employeeComboBox;
    @javafx.fxml.FXML
    private TableColumn endDateColumn;
    @javafx.fxml.FXML
    private Button addBenefitsButton;
    @javafx.fxml.FXML
    private Button updateBenefitsButton;
    @javafx.fxml.FXML
    private TableColumn startDateColumn;
    @javafx.fxml.FXML
    private TableColumn coverageColumn;
    @javafx.fxml.FXML
    private TableColumn benefitTypeColumn;
    @javafx.fxml.FXML
    private TableView benefitsTableView;
}
