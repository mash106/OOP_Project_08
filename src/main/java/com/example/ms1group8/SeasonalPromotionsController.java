package com.example.ms1group8;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class SeasonalPromotionsController {

    @FXML
    private ComboBox<String> seasonComboBox;

    @FXML
    private TextArea promotionConceptArea;

    @FXML
    private Button createPromotionBtn;

    @FXML
    private Button schedulePromotionBtn;

    @FXML
    private Button backBtn;

    @FXML
    private DatePicker promotionStartDatePicker;

    @FXML
    public void initialize() {
        seasonComboBox.setItems(FXCollections.observableArrayList("Spring", "Summer", "Autumn", "Winter"));
    }

    @FXML
    private void handleCreatePromotion(ActionEvent event) {
        String selectedSeason = seasonComboBox.getValue();
        String promotionDetails = promotionConceptArea.getText();

        if (selectedSeason == null || selectedSeason.isEmpty()) {
            showAlert(AlertType.ERROR, "Season Not Selected", "Please select a season for the promotion.");
            return;
        }

        if (promotionDetails == null || promotionDetails.isEmpty()) {
            showAlert(AlertType.ERROR, "Promotion Details Missing", "Please enter the promotion details.");
            return;
        }

        String message = "Promotion Created:\nSeason: " + selectedSeason + "\nDetails: " + promotionDetails;
        showAlert(AlertType.INFORMATION, "Promotion Created", message);

        promotionConceptArea.clear();
    }

    @FXML
    private void handleSchedulePromotion(ActionEvent event) {
        String selectedSeason = seasonComboBox.getValue();
        String promotionDetails = promotionConceptArea.getText();
        LocalDate startDate = promotionStartDatePicker.getValue();

        if (selectedSeason == null || selectedSeason.isEmpty()) {
            showAlert(AlertType.ERROR, "Season Not Selected", "Please select a season for the promotion.");
            return;
        }

        if (promotionDetails == null || promotionDetails.isEmpty()) {
            showAlert(AlertType.ERROR, "Promotion Details Missing", "Please enter the promotion details.");
            return;
        }

        if (startDate == null) {
            showAlert(AlertType.ERROR, "Date Not Selected", "Please select a start date for the promotion.");
            return;
        }

        String message = "Promotion Scheduled:\nSeason: " + selectedSeason + "\nDetails: " + promotionDetails
                + "\nPromotion will start from: " + startDate;
        showAlert(AlertType.INFORMATION, "Promotion Scheduled", message);

        promotionConceptArea.clear();
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SalesAndMarketingManager.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Button getCreatePromotionBtn() {
        return createPromotionBtn;
    }

    public void setCreatePromotionBtn(Button createPromotionBtn) {
        this.createPromotionBtn = createPromotionBtn;
    }

    public Button getSchedulePromotionBtn() {
        return schedulePromotionBtn;
    }

    public void setSchedulePromotionBtn(Button schedulePromotionBtn) {
        this.schedulePromotionBtn = schedulePromotionBtn;
    }

    public Button getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(Button backBtn) {
        this.backBtn = backBtn;
    }
}
