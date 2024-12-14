package com.example.oop_project_group_8.ms1group8;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerRelationshipController {

    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer, String> contactColumn;
    @FXML
    private TableColumn<Customer, String> statusColumn;
    @FXML
    private TextField customerSearchField;
    @FXML
    private Button createProfileBtn;
    @FXML
    private TextArea customerNotesArea;
    @FXML
    private ComboBox<String> customerComboBox;
    @FXML
    private Button applyNotesBtn;
    @FXML
    private Button backBtn;
    @FXML
    private TextField newCustomerNameField;
    @FXML
    private TextField newCustomerContactField;

    private final ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        contactColumn.setCellValueFactory(cellData -> cellData.getValue().contactProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        customerList.add(new Customer("John Doe", "123-456-7890", "Active"));
        customerList.add(new Customer("Jane Smith", "987-654-3210", "Inactive"));
        customerList.add(new Customer("Mahir Iqbal", "555-123-4567", "Active"));
        customerList.add(new Customer("Morshed Islam", "555-987-6543", "Inactive"));
        customerList.add(new Customer("Tabassum Siqdar", "555-234-5678", "Active"));

        customerTable.setItems(customerList);

        updateCustomerComboBox();
    }

    private void updateCustomerComboBox() {
        customerComboBox.getItems().clear();
        for (Customer customer : customerList) {
            customerComboBox.getItems().add(customer.getName());
        }
    }

    @FXML
    public void handleCreateProfile(ActionEvent actionEvent) {
        String name = newCustomerNameField.getText();
        String contact = newCustomerContactField.getText();

        if (name.isEmpty() || contact.isEmpty()) {
            showAlert("Invalid Input", "Please enter both customer name and contact.");
        } else {
            Customer newCustomer = new Customer(name, contact, "New");
            customerList.add(newCustomer);
            newCustomerNameField.clear();
            newCustomerContactField.clear();
            updateCustomerComboBox();
            showAlert("Profile Created", "A new profile for " + name + " has been created.");
        }
    }

    @FXML
    public void handleCustomerSearch(ActionEvent actionEvent) {
        String searchQuery = customerSearchField.getText().toLowerCase();
        ObservableList<Customer> filteredList = FXCollections.observableArrayList();

        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(searchQuery)) {
                filteredList.add(customer);
            }
        }

        customerTable.setItems(filteredList);
    }

    @FXML
    public void handleApplyNotes(ActionEvent actionEvent) {
        String notes = customerNotesArea.getText();
        String selectedCustomer = customerComboBox.getValue();

        if (selectedCustomer == null || selectedCustomer.isEmpty()) {
            showAlert("No Customer Selected", "Please select a customer from the combo box to add notes.");
        } else {
            showAlert("Notes Saved", "Notes for " + selectedCustomer + " have been saved.");
            customerNotesArea.clear();
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/ms1group8/SalesAndMarketingManager.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static class Customer {
        private final StringProperty name;
        private final StringProperty contact;
        private final StringProperty status;

        public Customer(String name, String contact, String status) {
            this.name = new SimpleStringProperty(name);
            this.contact = new SimpleStringProperty(contact);
            this.status = new SimpleStringProperty(status);
        }

        public StringProperty nameProperty() {
            return name;
        }

        public StringProperty contactProperty() {
            return contact;
        }

        public StringProperty statusProperty() {
            return status;
        }

        public String getName() {
            return name.get();
        }

        public String getContact() {
            return contact.get();
        }

        public String getStatus() {
            return status.get();
        }
    }
}
