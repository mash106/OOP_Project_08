package com.example.oop_project_group_8.Mahir_2211582;

public class Product {
    private String productName;
    private String species;
    private String productDetails;
    private double price;

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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", species='" + species + '\'' +
                ", productDetails='" + productDetails + '\'' +
                ", price=" + price +
                '}';
    }
}