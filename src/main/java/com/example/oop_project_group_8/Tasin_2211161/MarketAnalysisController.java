package com.example.oop_project_group_8.Tasin_2211161;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MarketAnalysisController {

    @FXML
    private ComboBox<String> fishSpeciesComboBox;

    @FXML
    private TableView<PriceHistory> priceHistoryTable;

    @FXML
    private TableColumn<PriceHistory, String> dateColumn;

    @FXML
    private TableColumn<PriceHistory, String> priceColumn;

    @FXML
    private TextField newMarketPriceField;

    @FXML
    private Button updatePricesBtn;

    @FXML
    private Button backBtn;

    private final ObservableList<PriceHistory> priceHistoryList = FXCollections.observableArrayList();
    private final Map<String, ObservableList<PriceHistory>> fishPriceHistoryMap = new HashMap<>();

    @FXML
    public void initialize() {
        fishSpeciesComboBox.setItems(FXCollections.observableArrayList("Tilapia", "Rohu", "Carp", "Pangasius", "Catla", "Grass Carp"));

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        fishPriceHistoryMap.put("Tilapia", FXCollections.observableArrayList(
                new PriceHistory("2024-12-01", "TK190.00"),
                new PriceHistory("2024-11-15", "TK240.50"),
                new PriceHistory("2024-11-01", "TK220.00")
        ));

        fishPriceHistoryMap.put("Rohu", FXCollections.observableArrayList(
                new PriceHistory("2024-12-01", "TK210.00"),
                new PriceHistory("2024-11-15", "TK250.50"),
                new PriceHistory("2024-11-01", "TK230.00")
        ));

        fishPriceHistoryMap.put("Carp", FXCollections.observableArrayList(
                new PriceHistory("2024-12-01", "TK200.00"),
                new PriceHistory("2024-11-15", "TK245.50"),
                new PriceHistory("2024-11-01", "TK225.00")
        ));

        fishPriceHistoryMap.put("Pangasius", FXCollections.observableArrayList(
                new PriceHistory("2024-12-01", "TK180.00"),
                new PriceHistory("2024-11-15", "TK230.50"),
                new PriceHistory("2024-11-01", "TK210.00")
        ));

        fishPriceHistoryMap.put("Catla", FXCollections.observableArrayList(
                new PriceHistory("2024-12-01", "TK220.00"),
                new PriceHistory("2024-11-15", "TK260.50"),
                new PriceHistory("2024-11-01", "TK240.00")
        ));

        fishPriceHistoryMap.put("Grass Carp", FXCollections.observableArrayList(
                new PriceHistory("2024-12-01", "TK195.00"),
                new PriceHistory("2024-11-15", "TK235.50"),
                new PriceHistory("2024-11-01", "TK215.00")
        ));

        fishSpeciesComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateMarketTrends();
        });

        priceHistoryTable.setItems(priceHistoryList);
    }

    @FXML
    private void updateMarketTrends() {
        String selectedSpecies = fishSpeciesComboBox.getSelectionModel().getSelectedItem();
        if (selectedSpecies != null) {
            priceHistoryList.setAll(fishPriceHistoryMap.get(selectedSpecies));
        }
    }

    @FXML
    private void handleUpdatePrices() {
        String selectedSpecies = fishSpeciesComboBox.getSelectionModel().getSelectedItem();
        String newPrice = newMarketPriceField.getText();

        if (selectedSpecies == null) {
            showAlert("Error", "Please select a fish species.");
            return;
        }

        if (newPrice != null && !newPrice.isEmpty()) {
            PriceHistory newEntry = new PriceHistory("2024-12-13", newPrice);
            fishPriceHistoryMap.get(selectedSpecies).add(newEntry);
            updateMarketTrends();
            newMarketPriceField.clear();
            showAlert("Success", "Price for " + selectedSpecies + " has been updated.");
        } else {
            showAlert("Error", "Please enter a new price.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/ms1group8/SalesAndMarketingManager.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Button getUpdatePricesBtn() {
        return updatePricesBtn;
    }

    public void setUpdatePricesBtn(Button updatePricesBtn) {
        this.updatePricesBtn = updatePricesBtn;
    }

    public Button getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(Button backBtn) {
        this.backBtn = backBtn;
    }

    public static class PriceHistory {
        private final StringProperty date;
        private final StringProperty price;

        public PriceHistory(String date, String price) {
            this.date = new SimpleStringProperty(date);
            this.price = new SimpleStringProperty(price);
        }

        public String getDate() {
            return date.get();
        }

        public String getPrice() {
            return price.get();
        }

        public StringProperty dateProperty() {
            return date;
        }

        public StringProperty priceProperty() {
            return price;
        }
    }
}
