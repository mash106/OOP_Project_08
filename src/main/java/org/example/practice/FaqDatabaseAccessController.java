package org.example.practice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FaqDatabaseAccessController extends AnchorPane {

    @FXML
    private TextField searchField;

    @FXML
    private TreeView<String> faqCategoriesTree;

    @FXML
    private TextArea faqContentArea;

    @FXML
    private Button submitFAQRequestButton;


    @FXML
    private void handleSearch() {
        String searchText = searchField.getText();

        System.out.println("Searching for: " + searchText);
    }


    @FXML
    private void handleCategorySelection(MouseEvent event) {
        String selectedCategory = faqCategoriesTree.getSelectionModel().getSelectedItem() != null ?
                faqCategoriesTree.getSelectionModel().getSelectedItem().getValue() : "None";
        faqContentArea.setText("Selected Category: " + selectedCategory);
    }


    @FXML
    private void submitFAQRequest() {
        String searchQuery = searchField.getText();
        if (searchQuery.isEmpty()) {
            faqContentArea.setText("Please enter a search query.");
        } else {
            faqContentArea.setText("You submitted the FAQ request: " + searchQuery);

        }
    }
}
