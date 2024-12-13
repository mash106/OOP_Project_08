package com.example.oop_project_group_8;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class loginSceneController
{
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private TextField userIdField;
    @javafx.fxml.FXML
    private Button loginButton;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label loginLabel;

    @javafx.fxml.FXML
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

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String userId = userIdField.getText().trim();
        String email = emailField.getText().trim();
        String selectedUserType = userTypeComboBox.getValue();
        System.out.println(selectedUserType);
        // Validate user ID
        boolean isUserIdValid = userId.matches("\\d+") && userId.length() < 5;

        // Validate email
        boolean isEmailValid = email.endsWith("@gmail.com");

        if (!isUserIdValid || !isEmailValid) {
            loginLabel.setText("Incorrect user ID or email");
            return;
        }

        // Check if user type is selected
        if (selectedUserType == null) {
            loginLabel.setText("Please select a user type");
            return;
        }

        // Determine the FXML scene to switch to
        String fxmlFile;
        switch (selectedUserType) {
            case "Customer":
                fxmlFile = "/com/example/oop_project_group_8/Mahir - 2211582/customerDashboardScene.fxml";
                break;
            case "Inventory Manager":
                fxmlFile = "inventoryManagerDashboardScene.fxml";
                break;
            case "Hatchery Technician":
                fxmlFile = "hatcheryTechnician.fxml";
                break;
            case "Sales & Marketing Manager":
                fxmlFile = "salesMarketingManager.fxml";
                break;
            case "HR Manager":
                fxmlFile = "hrManager.fxml";
                break;
            case "Customer Service Representative":
                fxmlFile = "customerServiceRepresentative.fxml";
                break;
            default:
                loginLabel.setText("Unknown user type");
                return;
        }

        // Load the next scene
        try {
            String resourcePath = "com/example/oop_project_group_8/" + fxmlFile;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourcePath));
            Parent root = loader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            loginLabel.setText("Error loading the next scene. Check resource paths.");
        }
    }
}
