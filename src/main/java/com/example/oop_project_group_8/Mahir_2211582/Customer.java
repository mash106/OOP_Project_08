package com.example.oop_project_group_8.Mahir_2211582;

import com.example.oop_project_group_8.User;

class Customer extends User {

    public Customer(String userId, String email, String password) {
        super(userId, email, password);
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    public void browseProducts() {
        System.out.println("Displaying product catalog...");

    }

    public void viewProductDetails(String productId) {
        System.out.println("Fetching details for product ID: " + productId);

    }

    public void placeOrder() {
        System.out.println("Placing an order...");
    }

    public void trackOrderStatus(String orderId) {
        System.out.println("Tracking status for order ID: " + orderId);
    }

    public void requestRefund(String orderId, String reason) {
        System.out.println("Requesting refund for order ID: " + orderId);
    }

    public void submitReview(String productId, int rating, String review) {
        System.out.println("Submitting review for product ID: " + productId);
    }

    public void contactSupport(String issueType, String name, String email, String description) {
        System.out.println("Submitting support ticket...");
    }
}