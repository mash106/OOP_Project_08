package com.example.oop_project_group_8.Mahir_2211582;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class TrackCostSceneController {

    @FXML
    private Label totalInventoryValueLabel;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private PieChart costTrackingPieChart;

    private ObservableList<Item> inventoryList;

    @FXML
    public void initialize() {
        inventoryList = InventoryData.getInventoryList();

        categoryComboBox.setItems(FXCollections.observableArrayList("All Categories", "Fingerlings", "Fish Feed", "Water Quality Enhancers"));
        categoryComboBox.getSelectionModel().selectFirst();
        updateTotalInventoryValue();
    }

    @FXML
    private void generateCostPieChartButtonOnClicked(ActionEvent actionEvent) {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        String selectedCategory = categoryComboBox.getValue();

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Item item : inventoryList) {
            if ((selectedCategory.equals("All Categories") || item.getCategory().equals(selectedCategory)) &&
                    (startDate == null || endDate == null || isWithinDateRange(item, startDate, endDate))) {
                pieChartData.add(new PieChart.Data(item.getItemName(), item.getPrice() * item.getQuantity()));
            }
        }

        costTrackingPieChart.setData(pieChartData);
    }

    @FXML
    private void costBreakdownButtonOnClicked(ActionEvent actionEvent) {
        System.out.println("Detailed cost breakdown displayed.");
    }

    private void updateTotalInventoryValue() {
        double totalValue = 0.0;
        for (Item item : inventoryList) {
            totalValue += item.getPrice() * item.getQuantity();
        }
        totalInventoryValueLabel.setText("Total Inventory Value: BDT " + String.format("%.2f", totalValue));
    }

    private boolean isWithinDateRange(Item item, LocalDate startDate, LocalDate endDate) {
        return true;
    }

    @FXML
    public void backButtonOnClicked(ActionEvent actionEvent) {
    }
}
