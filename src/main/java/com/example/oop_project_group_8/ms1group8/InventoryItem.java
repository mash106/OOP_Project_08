package com.example.oop_project_group_8.ms1group8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;

public class InventoryItem {

    private final StringProperty itemName;
    private final IntegerProperty stock;
    private final StringProperty status;
    private final IntegerProperty demand;

    public InventoryItem(String itemName, int stock, String status) {
        this.itemName = new SimpleStringProperty(itemName);
        this.stock = new SimpleIntegerProperty(stock);
        this.status = new SimpleStringProperty(status);
        this.demand = new SimpleIntegerProperty(0);
    }

    public InventoryItem(String itemName, int stock, int demand) {
        this.itemName = new SimpleStringProperty(itemName);
        this.stock = new SimpleIntegerProperty(stock);
        this.status = new SimpleStringProperty("In Stock");
        this.demand = new SimpleIntegerProperty(demand);
    }

    public String getItemName() {
        return itemName.get();
    }

    public int getStock() {
        return stock.get();
    }

    public String getStatus() {
        return status.get();
    }

    public int getDemand() {
        return demand.get();
    }

    public StringProperty itemNameProperty() {
        return itemName;
    }

    public IntegerProperty stockProperty() {
        return stock;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public IntegerProperty demandProperty() {
        return demand;
    }
}
