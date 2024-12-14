package com.example.oop_project_group_8.Mahir_2211582;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderHistorySceneController {

    @FXML
    private TableView<Order> orderHistoryTable;

    @FXML
    private TableColumn<Order, String> orderIdTC;

    @FXML
    private TableColumn<Order, String> orderDatePlacedTC;

    @FXML
    private TableColumn<Order, String> orderDateReceivedTC;

    @FXML
    private TableColumn<Order, Double> orderTotalAmountTC;

    private ObservableList<Order> orderHistoryList;

    @FXML
    public void initialize() {
        orderHistoryList = FXCollections.observableArrayList(
                new Order("ORD101", "2024-12-01", "10:30 AM", 1500.0, "Paid", "Delivered", "Delivered on 2024-12-15"),
                new Order("ORD102", "2024-12-05", "02:15 PM", 3000.0, "Paid", "Delivered", "Delivered on 2024-12-20"),
                new Order("ORD103", "2024-12-10", "09:00 AM", 2000.0, "Paid", "Delivered", "Delivered on 2024-12-22"),
                new Order("ORD104", "2024-12-11", "11:45 AM", 4000.0, "Paid", "Delivered", "Shipment in progress")
        );

        orderIdTC.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        orderDatePlacedTC.setCellValueFactory(new PropertyValueFactory<>("datePlaced"));
        orderDateReceivedTC.setCellValueFactory(new PropertyValueFactory<>("shipmentDetails"));
        orderTotalAmountTC.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        orderHistoryTable.setItems(orderHistoryList);
    }

    @FXML
    public void viewInvoiceButtonOnClicked(ActionEvent actionEvent) {
        Order selectedOrder = orderHistoryTable.getSelectionModel().getSelectedItem();

        if (selectedOrder != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("invoiceScene.fxml"));
                Parent root = loader.load();

                InvoiceSceneController invoiceController = loader.getController();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Invoice for Order: " + selectedOrder.getOrderId());
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please select an order to view the invoice.");
        }
    }

    @FXML
    public void backButtonOnClicked(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("customerDashboardScene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
