package com.example.oop_project_group_8.org.example.practice.practice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class FaqDatabaseAccessController {

    @FXML
    private TextField searchField;

    @FXML
    private TreeView<String> faqCategoriesTree;

    @FXML
    private TextArea faqContentArea;

    @FXML
    private Button submitFAQRequestButton;
    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        // Initialize the TreeView with sample categories
        TreeItem<String> rootItem = new TreeItem<>("FAQ Categories");
        rootItem.setExpanded(true);

        TreeItem<String> category1 = new TreeItem<>("General Questions");
        TreeItem<String> category2 = new TreeItem<>("Account Management");
        TreeItem<String> category3 = new TreeItem<>("Technical Support");
        TreeItem<String> category4 = new TreeItem<>("Billing");

        rootItem.getChildren().addAll(category1, category2, category3, category4);

        faqCategoriesTree.setRoot(rootItem);
        faqCategoriesTree.setShowRoot(true);

        // Clear content area on start
        faqContentArea.clear();
    }


    @FXML
    private void handleSearch() {
        String searchText = searchField.getText().trim();
        if (!searchText.isEmpty()) {
            System.out.println("Searching for: " + searchText);
            faqContentArea.setText("Searching for FAQs related to: " + searchText);
        } else {
            faqContentArea.setText("Search field is empty.");
        }
    }


    @FXML
    private void handleCategorySelection(MouseEvent event) {
        TreeItem<String> selectedItem = faqCategoriesTree.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            faqContentArea.setText("Selected Category: " + selectedItem.getValue());
        } else {
            faqContentArea.setText("No category selected.");
        }
    }


    @FXML
    private void submitFAQRequest() {
        String searchQuery = searchField.getText().trim();
        if (searchQuery.isEmpty()) {
            faqContentArea.setText("Please enter a search query.");
        } else {
            faqContentArea.setText("You submitted the FAQ request: " + searchQuery);
            System.out.println("FAQ Request Submitted: " + searchQuery);
        }
    }

    @FXML
    public void handleBackAction(ActionEvent actionEvent) {
    }
}
