package com.example.oop_project_group_8.Tasin_2211161;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

public class FishStockRecordsController {

    @FXML
    private TableView<com.example.oop_project_group_8.Tasin_2211161.FishStock> stockTable;

    @FXML
    private TableColumn<com.example.oop_project_group_8.Tasin_2211161.FishStock, String> speciesColumn;

    @FXML
    private TableColumn<com.example.oop_project_group_8.Tasin_2211161.FishStock, String> tankColumn;

    @FXML
    private TableColumn<com.example.oop_project_group_8.Tasin_2211161.FishStock, Integer> countColumn;

    @FXML
    private TextField growthRateField;

    @FXML
    private TextField mortalityRateField;

    @FXML
    private Button generateReportBtn;

    @FXML
    private Button backButton;

    private final ObservableList<com.example.oop_project_group_8.Tasin_2211161.FishStock> fishStockList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        speciesColumn.setCellValueFactory(cellData -> cellData.getValue().speciesProperty());
        tankColumn.setCellValueFactory(cellData -> cellData.getValue().tankProperty());
        countColumn.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());
        speciesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tankColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        countColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object != null ? object.toString() : "";
            }

            @Override
            public Integer fromString(String string) {
                try {
                    return Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        }));

        fishStockList.add(new com.example.oop_project_group_8.Tasin_2211161.FishStock("Tilapia", "Tank A", 1000));
        fishStockList.add(new com.example.oop_project_group_8.Tasin_2211161.FishStock("Ruhu", "Tank B", 800));
        fishStockList.add(new com.example.oop_project_group_8.Tasin_2211161.FishStock("Carp", "Tank C", 600));
        fishStockList.add(new com.example.oop_project_group_8.Tasin_2211161.FishStock("Pangasius", "Tank D", 1500));
        fishStockList.add(new com.example.oop_project_group_8.Tasin_2211161.FishStock("Catla", "Tank E", 1100));
        fishStockList.add(new com.example.oop_project_group_8.Tasin_2211161.FishStock("Grass Carp", "Tank F", 950));

        stockTable.setItems(fishStockList);

        growthRateField.setText("5.5%");
        mortalityRateField.setText("1.2%");
    }

    @FXML
    private void handleGenerateReport() {
        System.out.println("Generating stock report...");
        System.out.println("Fish Stock Report:");
        for (com.example.oop_project_group_8.Tasin_2211161.FishStock stock : fishStockList) {
            System.out.println("Species: " + stock.getSpecies() + ", Tank: " + stock.getTank() + ", Count: " + stock.getCount());
        }
        growthRateField.setText("Updated Growth Rate: 6.2%");
        mortalityRateField.setText("Updated Mortality Rate: 1.5%");
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HatcheryTechnician.fxml"));
            AnchorPane hatcheryTechnicianPane = loader.load();

            Stage stage = (Stage) backButton.getScene().getWindow();

            Scene scene = new Scene(hatcheryTechnicianPane);
            stage.setScene(scene);

            HatcheryTechnicianController hatcheryTechnicianController = loader.getController();
            hatcheryTechnicianController.initialize();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while navigating back to the Hatchery Technician dashboard.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Button getGenerateReportBtn() {
        return generateReportBtn;
    }

    public void setGenerateReportBtn(Button generateReportBtn) {
        this.generateReportBtn = generateReportBtn;
    }
}
