package com.example.ms1group8;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class FishTransportationController
{
    @javafx.fxml.FXML
    private TextArea packingDetailsArea;
    @javafx.fxml.FXML
    private TableColumn quantityColumn;
    @javafx.fxml.FXML
    private TableColumn clientColumn;
    @javafx.fxml.FXML
    private Button coordinateTransportBtn;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private TableView deliveryScheduleTable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCoordinateTransport(ActionEvent actionEvent) {
    }
}