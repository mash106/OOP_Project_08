package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InventorySalesPlanningController
{
    @javafx.fxml.FXML
    private TableView inventoryTable;
    @javafx.fxml.FXML
    private Button updateProductionBtn;
    @javafx.fxml.FXML
    private TableColumn demandColumn;
    @javafx.fxml.FXML
    private TextField demandForecastField;
    @javafx.fxml.FXML
    private TableColumn productColumn;
    @javafx.fxml.FXML
    private TableColumn stockColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleUpdateProduction(ActionEvent actionEvent) {
    }
}