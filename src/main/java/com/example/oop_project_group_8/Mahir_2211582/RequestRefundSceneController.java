package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class RequestRefundSceneController
{
    @javafx.fxml.FXML
    private TextArea refundReasonTextArea;
    @javafx.fxml.FXML
    private TableView refundEligibleOrdersTable;
    @javafx.fxml.FXML
    private TableColumn refundDateTC;
    @javafx.fxml.FXML
    private TableColumn refundOrderIdTC;
    @javafx.fxml.FXML
    private TableColumn refundProductTC;
    @javafx.fxml.FXML
    private TableColumn refundStatusTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitRefundRequestButtonOnClicked(ActionEvent actionEvent) {
    }
}