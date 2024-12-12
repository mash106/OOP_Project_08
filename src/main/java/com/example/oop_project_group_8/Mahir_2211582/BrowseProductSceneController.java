package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BrowseProductSceneController
{
    @javafx.fxml.FXML
    private ComboBox productTypeComboBox;
    @javafx.fxml.FXML
    private TableView productCatalogTable;
    @javafx.fxml.FXML
    private TableColumn priceTC;
    @javafx.fxml.FXML
    private TableColumn productNameTC;
    @javafx.fxml.FXML
    private TableColumn speciesTC;
    @javafx.fxml.FXML
    private TableColumn productDetailsTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void viewProductDetailsButtonOnAction(ActionEvent actionEvent) {
    }
}