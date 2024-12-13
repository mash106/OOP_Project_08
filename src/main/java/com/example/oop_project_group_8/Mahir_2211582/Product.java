package com.example.oop_project_group_8.Mahir_2211582;

public class Product {
    private final String productName;
    private final String species;
    private final String productDetails;
    private final double price;

    public Product(String productName, String species, String productDetails, double price) {
        this.productName = productName;
        this.species = species;
        this.productDetails = productDetails;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public String getSpecies() {
        return species;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public double getPrice() {
        return price;
    }
}