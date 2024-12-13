package org.example.practice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class BenefitsAdministrationController {

    @FXML
    private ComboBox<String> employeeComboBox;

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

    @FXML
    private Label statusLabel;

    private ObservableList<Benefit> benefitsData;

    @FXML
    public void initialize() {

        employeeComboBox.getItems().addAll("Muhtasin Morshed", "Tasin", "Mark Jukarber", "Mahir");


        benefitTypeColumn.setCellValueFactory(cellData -> cellData.getValue().benefitTypeProperty());
        coverageColumn.setCellValueFactory(cellData -> cellData.getValue().coverageProperty());
        startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
        endDateColumn.setCellValueFactory(cellData -> cellData.getValue().endDateProperty());


        benefitsData = FXCollections.observableArrayList(
                new Benefit("Fish Hatchery Insurance", "Full Coverage", LocalDate.now(), LocalDate.now().plusMonths(12)),
                new Benefit("Water Quality Monitoring", "Partial Coverage", LocalDate.now(), LocalDate.now().plusMonths(6)),
                new Benefit("Employee Safety Program", "Full Coverage", LocalDate.now(), LocalDate.now().plusMonths(12))
        );

        benefitsTableView.setItems(benefitsData);


        addBenefitsButton.setOnAction(event -> handleAddBenefits());


        updateBenefitsButton.setOnAction(event -> handleUpdateBenefits());
    }

    private void handleAddBenefits() {
        String selectedEmployee = employeeComboBox.getValue();
        if (selectedEmployee != null) {
            // Add new benefit data (for simplicity, we use static data here)
            benefitsData.add(new Benefit("Fish Hatchery Support", "Full Coverage", LocalDate.now(), LocalDate.now().plusMonths(6)));
            statusLabel.setText("Added benefits for " + selectedEmployee);
            System.out.println("Added benefits for " + selectedEmployee);
        } else {
            statusLabel.setText("Please select an employee to add benefits.");
        }
    }

    private void handleUpdateBenefits() {
        String selectedEmployee = employeeComboBox.getValue();
        if (selectedEmployee != null) {

            if (!benefitsData.isEmpty()) {
                Benefit benefit = benefitsData.get(0);
                benefit.setCoverage("Updated Coverage for Fish Hatchery Program");
                benefitsTableView.refresh();
                statusLabel.setText("Updated benefits for " + selectedEmployee);
                System.out.println("Updated benefits for " + selectedEmployee);
            } else {
                statusLabel.setText("No benefits to update.");
            }
        } else {
            statusLabel.setText("Please select an employee to update benefits.");
        }
    }

    public void addBenefitsButton(ActionEvent actionEvent) {
    }

    public void updateBenefitsButton(ActionEvent actionEvent) {

    }

    // Class to represent Benefit data
    public static class Benefit {
        private String benefitType;
        private String coverage;  // Remove 'final' to allow modification
        private final LocalDate startDate;
        private final LocalDate endDate;

        public Benefit(String benefitType, String coverage, LocalDate startDate, LocalDate endDate) {
            this.benefitType = benefitType;
            this.coverage = coverage;
            this.startDate = startDate;
            this.endDate = endDate;
        }


        public String getBenefitType() {
            return benefitType;
        }

        public String getCoverage() {
            return coverage;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }


        public void setCoverage(String coverage) {
            this.coverage = coverage;
        }

        // Property methods for TableView bindings
        public javafx.beans.property.StringProperty benefitTypeProperty() {
            return new javafx.beans.property.SimpleStringProperty(benefitType);
        }

        public javafx.beans.property.StringProperty coverageProperty() {
            return new javafx.beans.property.SimpleStringProperty(coverage);
        }

        public javafx.beans.property.ObjectProperty<LocalDate> startDateProperty() {
            return new javafx.beans.property.SimpleObjectProperty<>(startDate);
        }

        public javafx.beans.property.ObjectProperty<LocalDate> endDateProperty() {
            return new javafx.beans.property.SimpleObjectProperty<>(endDate);
        }

        @Override
        public String toString() {
            return "Benefit{" +
                    "benefitType='" + benefitType + '\'' +
                    ", coverage='" + coverage + '\'' +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    '}';
        }
    }
}
