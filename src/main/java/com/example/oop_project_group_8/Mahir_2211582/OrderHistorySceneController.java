package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OrderHistorySceneController
{
    @javafx.fxml.FXML
    private TableView orderHistoryTable;
    @javafx.fxml.FXML
    private TableColumn orderTotalAmountTC;
    @javafx.fxml.FXML
    private TableColumn orderDatePlacedTC;
    @javafx.fxml.FXML
    private TableColumn orderDateReceivedTC;
    @javafx.fxml.FXML
    private TableColumn orderIdTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void viewInvoiceButtonOnClicked(ActionEvent actionEvent) {
    }
}