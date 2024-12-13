package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class RequestRefundSceneController {

    @javafx.fxml.FXML
    private TextArea refundReasonTextArea;

    @javafx.fxml.FXML
    private TableView<Order> refundEligibleOrdersTable;

    @javafx.fxml.FXML
    private TableColumn<Order, String> refundDateTC;

    @javafx.fxml.FXML
    private TableColumn<Order, String> refundOrderIdTC;

    @javafx.fxml.FXML
    private TableColumn<Order, String> refundProductTC;

    @javafx.fxml.FXML
    private TableColumn<Order, String> refundStatusTC;

    @javafx.fxml.FXML
    public void initialize() {

        refundDateTC.setCellValueFactory(new PropertyValueFactory<>("datePlaced"));
        refundOrderIdTC.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        refundProductTC.setCellValueFactory(new PropertyValueFactory<>("shipmentDetails"));
        refundStatusTC.setCellValueFactory(new PropertyValueFactory<>("shipmentStatus"));
        refundEligibleOrdersTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        loadEligibleOrders();
    }

    private void loadEligibleOrders() {
        refundEligibleOrdersTable.getItems().addAll(
                new Order("ORD12345", "2023-12-01", "14:00", 120.0, "Paid", "Eligible", "Product A"),
                new Order("ORD12346", "2023-12-05", "15:30", 200.0, "Paid", "Eligible", "Product B")
        );
    }

    @javafx.fxml.FXML
    public void submitRefundRequestButtonOnClicked(ActionEvent actionEvent) {
        Order selectedOrder = refundEligibleOrdersTable.getSelectionModel().getSelectedItem();

        if (selectedOrder == null) {
            showAlert("Error", "No Order Selected", "Please select an order to request a refund.", Alert.AlertType.ERROR);
            return;
        }
        String refundReason = refundReasonTextArea.getText().trim();

        if (refundReason.isEmpty()) {
            showAlert("Error", "No Refund Reason Provided", "Please provide a reason for the refund.", Alert.AlertType.ERROR);
            return;
        }

        boolean isSuccess = submitRefundRequest(selectedOrder, refundReason);

        if (isSuccess) {
            showAlert("Success", "Refund Request Submitted", "Your refund request has been successfully registered.", Alert.AlertType.INFORMATION);
            refundReasonTextArea.clear();
            refundEligibleOrdersTable.getSelectionModel().clearSelection();
        } else {
            showAlert("Error", "Submission Failed", "There was an error processing your refund request. Please try again.", Alert.AlertType.ERROR);
        }
    }

    private boolean submitRefundRequest(Order order, String reason) {;
        return true;
    }

    private void showAlert(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
