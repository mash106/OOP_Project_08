package org.example.practice;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LeaveManagementController {
    @javafx.fxml.FXML
    private ComboBox employeeComboBox;
    @javafx.fxml.FXML
    private TableColumn endDateColumn;
    @javafx.fxml.FXML
    private Button approveRejectButton;
    @javafx.fxml.FXML
    private TableColumn startDateColumn;
    @javafx.fxml.FXML
    private TableColumn leaveTypeColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private Button applyLeaveButton;
    @javafx.fxml.FXML
    private TableView leaveTableView;
}
