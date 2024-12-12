package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManageSupplierInfoSceneController
{
    @javafx.fxml.FXML
    private TableView supplierTable;
    @javafx.fxml.FXML
    private TextField supplierNameTF;
    @javafx.fxml.FXML
    private ComboBox productSuppliedCB;
    @javafx.fxml.FXML
    private TextField supplierContactTF;
    @javafx.fxml.FXML
    private TableColumn supplierContactTC;
    @javafx.fxml.FXML
    private TableColumn supplierIDTC;
    @javafx.fxml.FXML
    private TableColumn supplierProductsTC;
    @javafx.fxml.FXML
    private TableColumn supplierNameTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addNewSupplierButtonOnClicked(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void editSelectedSupplierButtonOnClicked(ActionEvent actionEvent) {
    }
}