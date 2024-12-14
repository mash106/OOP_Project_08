package com.example.oop_project_group_8.Mahir_2211582;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MonitorInventorySceneController {
    @FXML
    private TableView<Item> inventoryTable;
    @FXML
    private TableColumn<Item, String> inventoryNameTC;
    @FXML
    private TableColumn<Item, String> inventoryCategoryTC;
    @FXML
    private TableColumn<Item, String> inventoryDescriptionTC;
    @FXML
    private TableColumn<Item, Double> inventoryPriceTC;
    @FXML
    private TableColumn<Item, Integer> inventoryQuantityTC;
    @FXML
    private ComboBox<String> inventorySortComboBox;

    private final ObservableList<Item> inventoryList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        inventoryNameTC.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        inventoryCategoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        inventoryDescriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        inventoryPriceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        inventoryQuantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        addSampleData();
        inventoryTable.setItems(inventoryList);
        inventorySortComboBox.setItems(FXCollections.observableArrayList("Name", "Price", "Quantity"));
        inventorySortComboBox.setOnAction(event -> sortInventory());
    }

    private void addSampleData() {
        inventoryList.addAll(
                new Item("Tilapia Fingerlings", "Fingerlings", "Healthy fingerlings (100 pcs)", 250.0, 50),
                new Item("Rohu Fingerlings", "Fingerlings", "High-quality hatchery Rohu (100 pcs)", 300.0, 40),
                new Item("Carp Feed", "Fish Feed", "Nutrient-rich feed for carp (50 kg bag)", 2500.0, 20),
                new Item("Pangasius Feed", "Fish Feed", "Specialized feed for Pangasius (50 kg bag)", 3000.0, 15),
                new Item("pH Balancer", "Water Quality Enhancers", "Improves water quality (1 kg)", 1500.0, 25),
                new Item("Dissolved Oxygen Booster", "Water Quality Enhancers", "Ensures optimal oxygen levels (500 g)", 2000.0, 30),
                new Item("Catla Fingerlings", "Fingerlings", "Healthy Catla fingerlings (100 pcs)", 350.0, 45),
                new Item("Mrigal Fingerlings", "Fingerlings", "High-quality Mrigal (100 pcs)", 400.0, 35),
                new Item("Shrimp Feed", "Fish Feed", "Specialized feed for shrimp (50 kg bag)", 2800.0, 10),
                new Item("Floating Feed", "Fish Feed", "Ideal for surface feeders (50 kg bag)", 2600.0, 20),
                new Item("Probiotic", "Water Quality Enhancers", "Improves fish gut health (1 kg)", 1800.0, 12),
                new Item("Organic Fertilizer", "Water Quality Enhancers", "Boosts plankton growth (25 kg bag)", 1000.0, 40),
                new Item("Silver Carp Fingerlings", "Fingerlings", "Healthy silver carp (100 pcs)", 300.0, 30),
                new Item("Grass Carp Fingerlings", "Fingerlings", "Ideal for weed control (100 pcs)", 320.0, 25),
                new Item("Fish Vitamins", "Fish Feed", "Enhances fish growth (1 kg)", 2200.0, 18),
                new Item("Amur Carp Fingerlings", "Fingerlings", "Hardy and fast-growing (100 pcs)", 450.0, 22),
                new Item("Barramundi Fingerlings", "Fingerlings", "Premium quality Barramundi (50 pcs)", 500.0, 12),
                new Item("Aquatic pH Stabilizer", "Water Quality Enhancers", "Maintains stable pH levels (1 kg)", 1600.0, 20),
                new Item("Plankton Booster", "Water Quality Enhancers", "Increases natural food availability (500 g)", 1200.0, 25),
                new Item("Mud Carp Fingerlings", "Fingerlings", "Well-adapted for local environments (100 pcs)", 380.0, 28)
        );
    }


    private void sortInventory() {
        String selectedOption = inventorySortComboBox.getValue();
        if (selectedOption == null) return;

        switch (selectedOption) {
            case "Name" -> inventoryList.sort((i1, i2) -> i1.getItemName().compareToIgnoreCase(i2.getItemName()));
            case "Price" -> inventoryList.sort((i1, i2) -> Double.compare(i1.getPrice(), i2.getPrice()));
            case "Quantity" -> inventoryList.sort((i1, i2) -> Integer.compare(i1.getQuantity(), i2.getQuantity()));
        }
    }

    public ObservableList<Item> getInventoryList() {
        return inventoryList;
    }
}
