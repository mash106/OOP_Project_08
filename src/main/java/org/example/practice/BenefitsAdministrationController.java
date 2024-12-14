package org.example.practice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BenefitsAdministrationController {

    @FXML
    private ComboBox<String> employeeComboBox;

    @FXML
    private ComboBox<String> benefitTypeComboBox;

    @FXML
    private ComboBox<LocalDate> startDateComboBox;

    @FXML
    private ComboBox<String> coverageTypeComboBox;

    @FXML
    private ComboBox<LocalDate> endDateComboBox;

    @FXML
    private TableView<Benefit> benefitsTableView;

    @FXML
    private TableColumn<Benefit, String> benefitTypeColumn;

    @FXML
    private TableColumn<Benefit, String> coverageColumn;

    @FXML
    private TableColumn<Benefit, LocalDate> startDateColumn;

    @FXML
    private TableColumn<Benefit, LocalDate> endDateColumn;

    @FXML
    private Button addBenefitsButton;

    @FXML
    private Button updateBenefitsButton;

    private ObservableList<Benefit> benefitsData;
    private ObservableList<String> employees;
    private ObservableList<String> benefitTypes;
    private ObservableList<String> coverageTypes;

    @FXML
    public void initialize() {
        employees = FXCollections.observableArrayList(
                "Alice Brown", "David Smith", "Emma Jones", "Sophia White",
                "Liam Johnson", "Olivia Williams", "Mason Davis", "Isabella Garcia"
        );
        employeeComboBox.setItems(employees);

        benefitTypes = FXCollections.observableArrayList("Health Insurance", "Retirement Plan", "Dental Insurance");
        benefitTypeComboBox.setItems(benefitTypes);

        coverageTypes = FXCollections.observableArrayList("Full Coverage", "Partial Coverage");
        coverageTypeComboBox.setItems(coverageTypes);

        ObservableList<LocalDate> dates = FXCollections.observableArrayList();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 365; i++) {
            dates.add(today.plusDays(i));
        }
        startDateComboBox.setItems(dates);
        endDateComboBox.setItems(dates);

        benefitTypeColumn.setCellValueFactory(new PropertyValueFactory<>("benefitType"));
        coverageColumn.setCellValueFactory(new PropertyValueFactory<>("coverage"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        benefitsData = FXCollections.observableArrayList();
        benefitsTableView.setItems(benefitsData);

        addBenefitsButton.setOnAction(e -> addBenefit());
        updateBenefitsButton.setOnAction(e -> updateBenefit());
    }

    private void addBenefit() {
        String employee = employeeComboBox.getValue();
        String benefitType = benefitTypeComboBox.getValue();
        String coverage = coverageTypeComboBox.getValue();
        LocalDate startDate = startDateComboBox.getValue();
        LocalDate endDate = endDateComboBox.getValue();

        if (employee == null || benefitType == null || coverage == null || startDate == null || endDate == null) {
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Please fill out all fields before adding a benefit.");
            return;
        }

        Benefit newBenefit = new Benefit(benefitType, coverage, startDate, endDate);
        benefitsData.add(newBenefit);
        showAlert(Alert.AlertType.INFORMATION, "Benefit Added", "Benefit successfully added for " + employee + ".");
    }

    private void updateBenefit() {
        Benefit selectedBenefit = benefitsTableView.getSelectionModel().getSelectedItem();
        if (selectedBenefit == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a benefit to update.");
            return;
        }

        selectedBenefit.setBenefitType(benefitTypeComboBox.getValue());
        selectedBenefit.setCoverage(coverageTypeComboBox.getValue());
        selectedBenefit.setStartDate(startDateComboBox.getValue());
        selectedBenefit.setEndDate(endDateComboBox.getValue());

        benefitsTableView.refresh(); // Refresh the table view
        showAlert(Alert.AlertType.INFORMATION, "Benefit Updated", "The selected benefit has been updated.");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static class Benefit {
        private String benefitType;
        private String coverage;
        private LocalDate startDate;
        private LocalDate endDate;

        public Benefit(String benefitType, String coverage, LocalDate startDate, LocalDate endDate) {
            this.benefitType = benefitType;
            this.coverage = coverage;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public String getBenefitType() {
            return benefitType;
        }

        public void setBenefitType(String benefitType) {
            this.benefitType = benefitType;
        }

        public String getCoverage() {
            return coverage;
        }

        public void setCoverage(String coverage) {
            this.coverage = coverage;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }
    }
}
