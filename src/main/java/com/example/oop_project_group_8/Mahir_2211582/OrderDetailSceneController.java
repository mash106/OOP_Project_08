package com.example.oop_project_group_8.Mahir_2211582;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OrderDetailSceneController {

    @FXML
    private Label orderIdLabel;
    @FXML
    private Label datePlacedLabel;
    @FXML
    private Label timePlacedLabel;
    @FXML
    private Label totalAmountLabel;
    @FXML
    private Label paymentStatusLabel;
    @FXML
    private Label shipmentStatusLabel;
    @FXML
    private Label shipmentDetailsLabel;

    public void setOrder(Order order) {
        orderIdLabel.setText("Order ID: " + order.getOrderId());
        datePlacedLabel.setText("Date Placed: " + order.getDatePlaced());
        timePlacedLabel.setText("Time Placed: " + order.getTimePlaced());
        totalAmountLabel.setText("Total Amount: " + order.getTotalAmount() + " BDT");
        paymentStatusLabel.setText("Payment Status: " + order.getPaymentStatus());
        shipmentStatusLabel.setText("Shipment Status: " + order.getShipmentStatus());
        shipmentDetailsLabel.setText("Shipment Details: " + order.getShipmentDetails());
    }
}
