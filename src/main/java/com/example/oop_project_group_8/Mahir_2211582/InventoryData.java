package com.example.oop_project_group_8.Mahir_2211582;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryData {
    private static ObservableList<Item> inventoryList = FXCollections.observableArrayList();

    public static ObservableList<Item> getInventoryList() {
        return inventoryList;
    }
}
