package com.example.oop_project_group_8.Mahir_2211582;

public class Supplier {
    private final int id;
    private String name;
    private String productsSupplied;
    private String contact;

    public Supplier(int id, String name, String productsSupplied, String contact) {
        this.id = id;
        this.name = name;
        this.productsSupplied = productsSupplied;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductsSupplied() {
        return productsSupplied;
    }

    public void setProductsSupplied(String productsSupplied) {
        this.productsSupplied = productsSupplied;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
