package com.example.ms1group8;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.time.LocalDate;

public class SalesReportController {

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private Button generateReportBtn;

    @FXML
    private Button exportPDFBtn;

    @FXML
    private Button backBtn;

    @FXML
    private PieChart salesPieChart;

    @FXML
    public void initialize() {
        reportTypeComboBox.getItems().addAll("Monthly Sales", "Quarterly Performance", "Annual Summary");
        reportTypeComboBox.getSelectionModel().selectFirst();  // Set default selection to "Monthly Sales"
    }

    @FXML
    private void handleGenerateReport() {
        String selectedReportType = reportTypeComboBox.getValue();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if (selectedReportType == null || startDate == null || endDate == null) {
            showAlert(AlertType.ERROR, "Error", "Please select report type and both start and end dates.");
            return;
        }

        if (startDate.isAfter(endDate)) {
            showAlert(AlertType.ERROR, "Invalid Dates", "Start date cannot be after end date.");
            return;
        }

        generatePieChart(selectedReportType);

        showAlert(AlertType.INFORMATION, "Report Generated",
                String.format("Report generated successfully for %s from %s to %s.",
                        selectedReportType, startDate, endDate));
    }


    private void generatePieChart(String reportType) {
        PieChart.Data[] reportData;

        switch (reportType) {
            case "Monthly Sales":
                reportData = new PieChart.Data[]{
                        new PieChart.Data("Tilapia", 20),
                        new PieChart.Data("Rohu", 15),
                        new PieChart.Data("Carp", 10),
                        new PieChart.Data("Pangasius", 25),
                        new PieChart.Data("Catla", 20),
                        new PieChart.Data("Grass Carp", 10)
                };
                break;
            case "Quarterly Performance":
                reportData = new PieChart.Data[]{
                        new PieChart.Data("Tilapia", 25),
                        new PieChart.Data("Rohu", 20),
                        new PieChart.Data("Carp", 15),
                        new PieChart.Data("Pangasius", 10),
                        new PieChart.Data("Catla", 20),
                        new PieChart.Data("Grass Carp", 10)
                };
                break;
            case "Annual Summary":
                reportData = new PieChart.Data[]{
                        new PieChart.Data("Tilapia", 30),
                        new PieChart.Data("Rohu", 25),
                        new PieChart.Data("Carp", 15),
                        new PieChart.Data("Pangasius", 10),
                        new PieChart.Data("Catla", 10),
                        new PieChart.Data("Grass Carp", 10)
                };
                break;
            default:
                reportData = new PieChart.Data[0];
                break;
        }

        salesPieChart.getData().clear();

        for (PieChart.Data data : reportData) {
            salesPieChart.getData().add(data);
        }
    }


    @FXML
    private void handleExportPDF() {
        showAlert(AlertType.INFORMATION, "Exported to PDF", "The report has been exported as PDF.");
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

    public Button getGenerateReportBtn() {
        return generateReportBtn;
    }

    public void setGenerateReportBtn(Button generateReportBtn) {
        this.generateReportBtn = generateReportBtn;
    }

    public Button getExportPDFBtn() {
        return exportPDFBtn;
    }

    public void setExportPDFBtn(Button exportPDFBtn) {
        this.exportPDFBtn = exportPDFBtn;
    }

    public Button getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(Button backBtn) {
        this.backBtn = backBtn;
    }
}
