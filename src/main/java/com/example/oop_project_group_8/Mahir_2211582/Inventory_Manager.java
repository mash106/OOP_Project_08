package com.example.oop_project_group_8.Mahir_2211582;

import com.example.oop_project_group_8.User;

class InventoryManager extends User {

    public InventoryManager(String userId, String email, String password) {
        super(userId, email, password);
    }

    @Override
    public String getRole() {
        return "Inventory Manager";
    }


    public void monitorInventoryLevel() {
        System.out.println("Displaying current inventory levels...");
    }

    public void addNewItem(String name, double price, String sku, int quantity) {
        System.out.println("Adding new item: " + name);

    }

    public void updateItemInfo(String sku, String newName, String newDescription, double newPrice) {
        System.out.println("Updating item info for SKU: " + sku);

    }

    public void orderItemsFromSupplier(String itemId, String supplierId) {
        System.out.println("Placing restock order for item ID: " + itemId);
            }

    public void createInventoryReport(String reportType, String startDate, String endDate) {
        System.out.println("Generating inventory report...");
    }

    public void trackInventoryCost() {
        System.out.println("Tracking inventory cost...");
    }

    public void manageSupplier(String supplierId, String newDetails) {
        System.out.println("Managing supplier info for ID: " + supplierId);
    }

    public void manageAlerts(int minStock, int expirationWarningDays) {
        System.out.println("Managing alerts for low stock and expiration...");
    }
}