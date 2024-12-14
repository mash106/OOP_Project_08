package com.example.oop_project_group_8.Mahir_2211582;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.util.HashMap;
import java.util.Map;

public class InventoryReportSceneController {
    @FXML
    private ComboBox<String> reportParameterComboBox;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private ComboBox<String> reportTypeComboBox;
    @FXML
    private PieChart reportPieChart;

    private ObservableList<Item> inventoryList;

    public void setInventoryList(ObservableList<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }

    @FXML
    public void initialize() {
        // Populate combo boxes with options
        reportParameterComboBox.setItems(FXCollections.observableArrayList("Category", "Individual Items"));
        reportTypeComboBox.setItems(FXCollections.observableArrayList("Quantity Distribution", "Price Distribution"));
    }

    @FXML
    public void generateReportButtonOnClicked(ActionEvent actionEvent) {
        String selectedParameter = reportParameterComboBox.getValue();
        String selectedReportType = reportTypeComboBox.getValue();

        if (selectedParameter == null || selectedReportType == null) {
            showAlert("Warning", "Please select both report parameters and report type.");
            return;
        }

        if (selectedParameter.equals("Category")) {
            if (selectedReportType.equals("Quantity Distribution")) {
                generateCategoryQuantityPieChart();
            } else if (selectedReportType.equals("Price Distribution")) {
                generateCategoryPricePieChart();
            }
        } else if (selectedParameter.equals("Individual Items")) {
            if (selectedReportType.equals("Quantity Distribution")) {
                generateItemQuantityPieChart();
            } else if (selectedReportType.equals("Price Distribution")) {
                generateItemPricePieChart();
            }
        }
    }

    private void generateCategoryQuantityPieChart() {
        Map<String, Integer> categoryQuantityMap = new HashMap<>();
        for (Item item : inventoryList) {
            categoryQuantityMap.put(item.getCategory(),
                    categoryQuantityMap.getOrDefault(item.getCategory(), 0) + item.getQuantity());
        }

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : categoryQuantityMap.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }

        reportPieChart.setData(pieChartData);
    }

    private void generateCategoryPricePieChart() {
        Map<String, Double> categoryPriceMap = new HashMap<>();
        for (Item item : inventoryList) {
            categoryPriceMap.put(item.getCategory(),
                    categoryPriceMap.getOrDefault(item.getCategory(), 0.0) + item.getPrice() * item.getQuantity());
        }

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<String, Double> entry : categoryPriceMap.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }

        reportPieChart.setData(pieChartData);
    }

    private void generateItemQuantityPieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Item item : inventoryList) {
            pieChartData.add(new PieChart.Data(item.getItemName(), item.getQuantity()));
        }

        reportPieChart.setData(pieChartData);
    }

    private void generateItemPricePieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Item item : inventoryList) {
            pieChartData.add(new PieChart.Data(item.getItemName(), item.getPrice() * item.getQuantity()));
        }

        reportPieChart.setData(pieChartData);
    }

    private void showAlert(String title, String content) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
