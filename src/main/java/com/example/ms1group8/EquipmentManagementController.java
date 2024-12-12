package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class EquipmentManagementController
{
    @javafx.fxml.FXML
    private Button scheduleMaintBtn;
    @javafx.fxml.FXML
    private TableColumn lastMaintainedColumn;
    @javafx.fxml.FXML
    private TableColumn equipmentColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private TextArea malfunctionNotesArea;
    @javafx.fxml.FXML
    private Button logMalfunctionBtn;
    @javafx.fxml.FXML
    private TableView equipmentTable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleScheduleMaintenance(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLogMalfunction(ActionEvent actionEvent) {
    }
}