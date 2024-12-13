package com.example.oop_project_group_8.Mahir_2211582;

public class Order {
    private String orderId;
    private String datePlaced;
    private String timePlaced;
    private double totalAmount;
    private String paymentStatus;
    private String shipmentStatus;
    private String shipmentDetails;

    public Order(String orderId, String datePlaced, String timePlaced, double totalAmount, String paymentStatus, String shipmentStatus, String shipmentDetails) {
        this.orderId = orderId;
        this.datePlaced = datePlaced;
        this.timePlaced = timePlaced;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.shipmentStatus = shipmentStatus;
        this.shipmentDetails = shipmentDetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(String datePlaced) {
        this.datePlaced = datePlaced;
    }

    public String getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(String timePlaced) {
        this.timePlaced = timePlaced;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public String getShipmentDetails() {
        return shipmentDetails;
    }

    public void setShipmentDetails(String shipmentDetails) {
        this.shipmentDetails = shipmentDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", datePlaced='" + datePlaced + '\'' +
                ", timePlaced='" + timePlaced + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", shipmentStatus='" + shipmentStatus + '\'' +
                ", shipmentDetails='" + shipmentDetails + '\'' +
                '}';
    }
}
