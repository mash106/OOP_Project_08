package com.example.oop_project_group_8.org.example.practice.practice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerInquiryController {

    @FXML
    private Button newInquiryButton;

    @FXML
    private TableView<Inquiry> inquiryTableView;

    @FXML
    private TableColumn<Inquiry, String> inquiryIdColumn;

    @FXML
    private TableColumn<Inquiry, String> customerNameColumn;

    @FXML
    private TableColumn<Inquiry, String> inquiryCategoryColumn;

    @FXML
    private TableColumn<Inquiry, String> statusColumn;

    @FXML
    private ComboBox<String> inquiryCategoryComboBox;

    @FXML
    private Button submitInquiryButton;

    @FXML
    private Button backButton;

    @FXML
    private Label statusLabel;

    private ObservableList<Inquiry> inquiriesData;

    @FXML
    public void initialize() {

        inquiryCategoryComboBox.getItems().addAll("Water Quality Issue", "Fish Stocking Inquiry", "Fish Health Concern");

        inquiryIdColumn.setCellValueFactory(cellData -> cellData.getValue().inquiryIdProperty());
        customerNameColumn.setCellValueFactory(cellData -> cellData.getValue().customerNameProperty());
        inquiryCategoryColumn.setCellValueFactory(cellData -> cellData.getValue().inquiryCategoryProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        inquiriesData = FXCollections.observableArrayList(
                new Inquiry("1", "Rahul Will", "Water Quality Issue", "Pending"),
                new Inquiry("2", "Rubel", "Fish Stocking Inquiry", "Resolved"),
                new Inquiry("3", "Aisha Khan", "Product Warranty Inquiry", "Pending"),
                new Inquiry("4", "Ravi Kumar", "Customer Service Inquiry", "Resolved"),
                new Inquiry("5", "Mei", "Shipping Delay Inquiry", "Pending"),
                new Inquiry("6", "Aisha", "Fish Quality Issue", "Pending"),
                new Inquiry("7", "John", "Water Quality Issue", "Resolved"),
                new Inquiry("8", "Liton Das", "Product Return Inquiry", "Pending"),
                new Inquiry("9", "Tanaka", "Payment Failure Inquiry", "Pending"),
                new Inquiry("10", "Yuki", "Subscription Inquiry", "Resolved")
        );

        inquiryTableView.setItems(inquiriesData);

        newInquiryButton.setOnAction(event -> handleNewInquiry());
        submitInquiryButton.setOnAction(event -> handleSubmitInquiry());
        backButton.setOnAction(event -> handleBackAction());
    }

    private void handleNewInquiry() {
        String selectedCategory = inquiryCategoryComboBox.getValue();
        if (selectedCategory != null) {
            Inquiry newInquiry = new Inquiry(String.valueOf(inquiriesData.size() + 1), "Muhtasin Morshed", selectedCategory, "Pending");
            inquiriesData.add(newInquiry);
            statusLabel.setText("New inquiry created for Muhtasin Morshed.");
            System.out.println("New inquiry created: " + newInquiry);
        } else {
            statusLabel.setText("Please select an inquiry category.");
        }
    }

    private void handleSubmitInquiry() {
        if (!inquiriesData.isEmpty()) {
            Inquiry lastInquiry = inquiriesData.get(inquiriesData.size() - 1);
            lastInquiry.setStatus("Submitted");
            statusLabel.setText("Inquiry submitted for: " + lastInquiry.getCustomerName());
            System.out.println("Inquiry submitted: " + lastInquiry);
        } else {
            statusLabel.setText("No inquiries to submit.");
        }
    }

    private void handleBackAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerserviceRepresentative.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Customer Service Representative");
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Failed to load the previous scene.");
        }
    }

    public static class Inquiry {
        private final String inquiryId;
        private final String customerName;
        private final String inquiryCategory;
        private String status;

        public Inquiry(String inquiryId, String customerName, String inquiryCategory, String status) {
            this.inquiryId = inquiryId;
            this.customerName = customerName;
            this.inquiryCategory = inquiryCategory;
            this.status = status;
        }

        public String getInquiryId() {
            return inquiryId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getInquiryCategory() {
            return inquiryCategory;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public javafx.beans.property.StringProperty inquiryIdProperty() {
            return new javafx.beans.property.SimpleStringProperty(inquiryId);
        }

        public javafx.beans.property.StringProperty customerNameProperty() {
            return new javafx.beans.property.SimpleStringProperty(customerName);
        }

        public javafx.beans.property.StringProperty inquiryCategoryProperty() {
            return new javafx.beans.property.SimpleStringProperty(inquiryCategory);
        }

        public javafx.beans.property.StringProperty statusProperty() {
            return new javafx.beans.property.SimpleStringProperty(status);
        }

        @Override
        public String toString() {
            return "Inquiry{" +
                    "inquiryId='" + inquiryId + '\'' +
                    ", customerName='" + customerName + '\'' +
                    ", inquiryCategory='" + inquiryCategory + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
