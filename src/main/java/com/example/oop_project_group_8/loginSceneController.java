package com.example.oop_project_group_8;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginSceneController
{
    @javafx.fxml.FXML
    private ComboBox userTypeComboBox;
    @javafx.fxml.FXML
    private TextField userIdField;
    @javafx.fxml.FXML
    private Button loginButton;
    @javafx.fxml.FXML
    private Button forgetPasswordButton;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private PasswordField passwordField;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll(
                "Customer",
                "Inventory Manager",
                "Hatchery Technician",
                "Sales & Marketing Manager",
                "HR Manager",
                "Customer Service Representative",
                "Feed Technician",
                "Hatchery Maintenance Manager"
        );

    }}