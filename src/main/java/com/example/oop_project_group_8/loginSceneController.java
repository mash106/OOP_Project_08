package com.example.oop_project_group_8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class loginSceneController {

    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private TextField userIdField;
    @FXML
    private Button loginButton;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginLabel;

    @FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll(
                "Customer",
                "Inventory Manager",
                "Hatchery Technician",
                "Sales & Marketing Manager",
                "HR Manager",
                "Customer Service Representative"
        );
    }

    @FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String userId = userIdField.getText().trim();
        String email = emailField.getText().trim();
        String selectedUserType = userTypeComboBox.getValue();
        System.out.println("Selected User Type: " + selectedUserType);

        boolean isUserIdValid = userId.matches("\\d+") && userId.length() < 5;
        boolean isEmailValid = email.endsWith("@gmail.com");

        if (!isUserIdValid || !isEmailValid) {
            loginLabel.setText("Incorrect user ID or email");
            return;
        }
        if (selectedUserType == null) {
            loginLabel.setText("Please select a user type");
            return;
        }

        String fxmlFile = getFxmlFileForUserType(selectedUserType);
        if (fxmlFile == null) {
            loginLabel.setText("Unknown user type");
            return;
        }

        switchScene(actionEvent, fxmlFile);
    }

    private String getFxmlFileForUserType(String userType) {
        switch (userType) {
            case "Customer":
                return "/com/example/oop_project_group_8/Mahir_2211582/customerDashboardScene.fxml";
            case "Inventory Manager":
                return "/com/example/oop_project_group_8/Mahir_2211582/inventoryManagerDashboardScene.fxml";
            case "Hatchery Technician":
                return "/com/example/oop_project_group_8/Tasin_2211161/HatcheryTechnician.fxml";
            case "Sales & Marketing Manager":
                return "/com/example/oop_project_group_8/Tasin_2211161/SalesAndMarketingManager.fxml";
            case "HR Manager":
                return "/com/example/oop_project_group_8/org/example/practice/practice/HR Manager dashboard.fxml";
            case "Customer Service Representative":
                return "/com/example/oop_project_group_8/org/example/practice/practice/CustomerserviceRepresentative.fxml";
            default:
                return null;
        }
    }

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            loginLabel.setText("Error loading the next scene. Check resource paths: " + e.getMessage());
        }
    }
}
