package com.example.oop_project_group_8.Mahir_2211582;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class TrackingOrderSceneController {
    @FXML
    private Label orderDetailsLabel;

    @FXML
    private TableView<Order> orderTable;

    @FXML
    private Label shipmentDetailsLabel;

    @FXML
    private TableColumn<Order, String> datePlacedTC;

    @FXML
    private TableColumn<Order, Double> totalAmountTC;

    @FXML
    private TableColumn<Order, String> timePlacedTC;

    @FXML
    private TableColumn<Order, String> orderIdTC;

    @FXML
    private TableColumn<Order, String> shipmentStatusTC;

    @FXML
    private TableColumn<Order, String> paymentStatusTC;

    @FXML
    public void initialize() {
        // Set up table columns
        orderIdTC.setCellValueFactory(data -> data.getValue().orderIdProperty());
        datePlacedTC.setCellValueFactory(data -> data.getValue().datePlacedProperty());
        timePlacedTC.setCellValueFactory(data -> data.getValue().timePlacedProperty());
        totalAmountTC.setCellValueFactory(data -> data.getValue().totalAmountProperty().asObject());
        paymentStatusTC.setCellValueFactory(data -> data.getValue().paymentStatusProperty());
        shipmentStatusTC.setCellValueFactory(data -> data.getValue().shipmentStatusProperty());

        // Add row click listener
        orderTable.setRowFactory(tv -> {
            TableRow<Order> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Order selectedOrder = row.getItem();
                    showOrderDetails(selectedOrder);
                }
            });
            return row;
        });
    }

    private void showOrderDetails(Order order) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/OrderDetailScene.fxml"));
            Parent root = loader.load();

            // Pass order details to the new controller
            OrderDetailSceneController controller = loader.getController();
            controller.setOrder(order);

            // Create a new stage for order details
            Stage stage = new Stage();
            stage.setTitle("Order Details");
            stage.setScene(new Scene(root));

            // Close the stage properly
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    stage.close();
                }
            });

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Order class definition (or replace it with your existing implementation)

}
