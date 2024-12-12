package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class ReviewProductSceneController
{
    @javafx.fxml.FXML
    private ComboBox selectProductComboBox;
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
    }

    @javafx.fxml.FXML
    public void submitReviewButtonOnClicked(ActionEvent actionEvent) {
    }
}