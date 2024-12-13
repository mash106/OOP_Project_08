package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.util.List;

public class ReviewProductSceneController {

    @javafx.fxml.FXML
    private ComboBox<Product> selectProductComboBox;

    @javafx.fxml.FXML
    private TextArea reviewTextArea;

    @javafx.fxml.FXML
    private ToggleGroup ratingTG;

    @javafx.fxml.FXML
    private RadioButton rating5RB;

    @javafx.fxml.FXML
    private RadioButton rating1RB;

    @javafx.fxml.FXML
    private RadioButton rating2RB;

    @javafx.fxml.FXML
    private RadioButton rating3RB;

    @javafx.fxml.FXML
    private RadioButton rating4RB;

    @javafx.fxml.FXML
    public void initialize() {
        List<Product> products = List.of(
                new Product("Tilapia Fingerlings", "Fingerlings", "Healthy fingerlings (100 pcs)", 250.0),
                new Product("Rohu Fingerlings", "Fingerlings", "High-quality hatchery Rohu (100 pcs)", 300.0),
                new Product("Carp Feed", "Fish Feed", "Nutrient-rich feed for carp (50 kg bag)", 2500.0),
                new Product("Pangasius Feed", "Fish Feed", "Specialized feed for Pangasius (50 kg bag)", 3000.0),
                new Product("pH Balancer", "Water Quality Enhancers", "Improves water quality (1 kg)", 1500.0),
                new Product("Dissolved Oxygen Booster", "Water Quality Enhancers", "Ensures optimal oxygen levels (500 g)", 2000.0),
                new Product("Catla Fingerlings", "Fingerlings", "Healthy Catla fingerlings (100 pcs)", 350.0),
                new Product("Mrigal Fingerlings", "Fingerlings", "High-quality Mrigal (100 pcs)", 400.0),
                new Product("Shrimp Feed", "Fish Feed", "Specialized feed for shrimp (50 kg bag)", 2800.0),
                new Product("Floating Feed", "Fish Feed", "Ideal for surface feeders (50 kg bag)", 2600.0),
                new Product("Probiotic", "Water Quality Enhancers", "Improves fish gut health (1 kg)", 1800.0),
                new Product("Organic Fertilizer", "Water Quality Enhancers", "Boosts plankton growth (25 kg bag)", 1000.0),
                new Product("Silver Carp Fingerlings", "Fingerlings", "Healthy silver carp (100 pcs)", 300.0),
                new Product("Grass Carp Fingerlings", "Fingerlings", "Ideal for weed control (100 pcs)", 320.0),
                new Product("Fish Vitamins", "Fish Feed", "Enhances fish growth (1 kg)", 2200.0),
                new Product("Amur Carp Fingerlings", "Fingerlings", "Hardy and fast-growing (100 pcs)", 450.0),
                new Product("Barramundi Fingerlings", "Fingerlings", "Premium quality Barramundi (50 pcs)", 500.0),
                new Product("Aquatic pH Stabilizer", "Water Quality Enhancers", "Maintains stable pH levels (1 kg)", 1600.0),
                new Product("Plankton Booster", "Water Quality Enhancers", "Increases natural food availability (500 g)", 1200.0),
                new Product("Mud Carp Fingerlings", "Fingerlings", "Well-adapted for local environments (100 pcs)", 380.0)
        );

        selectProductComboBox.getItems().addAll(products);
    }

    @javafx.fxml.FXML
    public void submitReviewButtonOnClicked(ActionEvent actionEvent) {
        Product selectedProduct = selectProductComboBox.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            showAlert("Error", "No Product Selected", "Please select a product to review.", Alert.AlertType.ERROR);
            return;
        }

        RadioButton selectedRating = (RadioButton) ratingTG.getSelectedToggle();
        if (selectedRating == null) {
            showAlert("Error", "No Rating Selected", "Please select a rating for the product.", Alert.AlertType.ERROR);
            return;
        }
        int rating = Integer.parseInt(selectedRating.getText());

        String reviewText = reviewTextArea.getText().trim();

        boolean isSuccess = submitReview(selectedProduct, rating, reviewText);

        if (isSuccess) {
            showAlert("Success", "Review Submitted", "Your review has been successfully sent to customer support.", Alert.AlertType.INFORMATION);
            reviewTextArea.clear();
            selectProductComboBox.getSelectionModel().clearSelection();
            ratingTG.getSelectedToggle().setSelected(false);
        } else {
            showAlert("Error", "Submission Failed", "There was an error submitting your review. Please try again.", Alert.AlertType.ERROR);
        }
    }

    private boolean submitReview(Product product, int rating, String reviewText) {

        System.out.println("Submitting review for product: " + product + ", Rating: " + rating + ", Review: " + reviewText);
        return true;
    }

    private void showAlert(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
