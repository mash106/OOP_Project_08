package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PlacingOrderSceneController
{
    @javafx.fxml.FXML
    private TableView cartTable;
    @javafx.fxml.FXML
    private ComboBox paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableColumn cartQuantityTC;
    @javafx.fxml.FXML
    private TextField cartAddressField;
    @javafx.fxml.FXML
    private TableColumn cartProductTC;
    @javafx.fxml.FXML
    private TextField cartNameField;
    @javafx.fxml.FXML
    private TableColumn cartPriceTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void placeOrderButtonOnClicked(ActionEvent actionEvent) {
    }
}