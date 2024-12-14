package com.example.oop_project_group_8.Mahir_2211582;

public class CartItem {
    private final String productName;
    private int quantity;
    private final double price;

    public CartItem(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
}