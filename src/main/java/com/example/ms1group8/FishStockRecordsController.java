package com.example.ms1group8;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FishStockRecordsController {

    @FXML
    private TableView<com.example.ms1group8.FishStock> stockTable;

    @FXML
    private TableColumn<com.example.ms1group8.FishStock, String> speciesColumn;

    @FXML
    private TableColumn<com.example.ms1group8.FishStock, String> tankColumn;

    @FXML
    private TableColumn<com.example.ms1group8.FishStock, Integer> countColumn;

    @FXML
    private TextField growthRateField;

    @FXML
    private TextField mortalityRateField;

    @FXML
    private Button generateReportBtn;

    private ObservableList<com.example.ms1group8.FishStock> fishStockList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        speciesColumn.setCellValueFactory(cellData -> cellData.getValue().speciesProperty());
        tankColumn.setCellValueFactory(cellData -> cellData.getValue().tankProperty());
        countColumn.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());

        fishStockList.add(new com.example.ms1group8.FishStock("Tilapia", "Tank A", 1000));
        fishStockList.add(new com.example.ms1group8.FishStock("Catfish", "Tank B", 1200));
        fishStockList.add(new com.example.ms1group8.FishStock("Salmon", "Tank C", 800));

        stockTable.setItems(fishStockList);

        growthRateField.setText("5.5%");
        mortalityRateField.setText("1.2%");
    }

    @FXML
    private void handleGenerateReport() {
        System.out.println("Generating stock report...");
        System.out.println("Fish Stock Report:");
        for (com.example.ms1group8.FishStock stock : fishStockList) {
            System.out.println("Species: " + stock.getSpecies() + ", Tank: " + stock.getTank() + ", Count: " + stock.getCount());
        }
        growthRateField.setText("Updated Growth Rate: 6.2%");
        mortalityRateField.setText("Updated Mortality Rate: 1.5%");
    }
}
