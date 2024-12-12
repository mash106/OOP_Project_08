package org.example.practice;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CustomerInquiryController {
    @javafx.fxml.FXML
    private Button newInquiryButton;
    @javafx.fxml.FXML
    private TableView inquiryTableView;
    @javafx.fxml.FXML
    private TableColumn customerNameColumn;
    @javafx.fxml.FXML
    private TableColumn inquiryCategoryColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private ComboBox inquiryCategoryComboBox;
    @javafx.fxml.FXML
    private TableColumn inquiryIdColumn;
    @javafx.fxml.FXML
    private Button submitInquiryButton;
}
