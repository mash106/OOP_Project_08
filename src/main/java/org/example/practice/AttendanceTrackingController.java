package org.example.practice;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AttendanceTrackingController {
    @javafx.fxml.FXML
    private TableView attendanceTableView;
    @javafx.fxml.FXML
    private TableColumn nameColumn;
    @javafx.fxml.FXML
    private DatePicker attendanceDatePicker;
    @javafx.fxml.FXML
    private TableColumn employeeIdColumn;
    @javafx.fxml.FXML
    private Button saveAttendanceButton;
    @javafx.fxml.FXML
    private TableColumn attendanceStatusColumn;
}
