package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProductDetailSceneController {

    @FXML
    private Label productNameLabel;

    @FXML
    private Label speciesLabel;

    @FXML
    private Label productDetailsLabel;

    @FXML
    private Label priceLabel;

    public void setProduct(BrowseProductSceneController.Product product) {
        if (product != null) {
            productNameLabel.setText(product.getProductName());
            speciesLabel.setText(product.getSpecies());
            productDetailsLabel.setText(product.getProductDetails());
            priceLabel.setText(String.format("BDT %.2f", product.getPrice()));
        }
    }

    @FXML
    public void addToCartButtonOnClicked(ActionEvent actionEvent) {
    }
}
