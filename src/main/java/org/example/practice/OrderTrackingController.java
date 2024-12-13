package org.example.practice;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OrderTrackingController {


    @FXML
    private TextField orderNumberField;

    @FXML
    private TableView<OrderDetail> orderDetailsTable;

    @FXML
    private TableColumn<OrderDetail, String> detailColumn;

    @FXML
    private TableColumn<OrderDetail, String> valueColumn;

    @FXML
    private ComboBox<String> orderStatusComboBox;

    @FXML
    private TextArea updateNotesArea;


    @FXML
    private void handleUpdateOrder() {
        String orderNumber = orderNumberField.getText();
        String orderStatus = orderStatusComboBox.getValue();
        String updateNotes = updateNotesArea.getText();

        if (orderNumber.isEmpty() || orderStatus == null || updateNotes.isEmpty()) {
            showAlert("Error", "Please fill in all fields before updating the order.");
            return;
        }


        System.out.println("Order Updated:");
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Update Notes: " + updateNotes);

        showAlert("Success", "Order updated successfully!");
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public static class OrderDetail {
        private String detail;
        private String value;

        public OrderDetail(String detail, String value) {
            this.detail = detail;
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public String getValue() {
            return value;
        }
    }
}