package com.example.oop_project_group_8.Mahir_2211582;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        ObservableList<Order> orders = FXCollections.observableArrayList(
                new Order("ORD001", "2024-12-01", "10:30 AM", 1500.0, "Paid", "Shipped", "Shipment on the way. Estimated delivery: 2024-12-15"),
                new Order("ORD002", "2024-12-05", "02:15 PM", 3000.0, "Pending", "Processing", "Shipment is being prepared."),
                new Order("ORD003", "2024-12-10", "09:00 AM", 2000.0, "Paid", "Delivered", "Delivered on 2024-12-12"),
                new Order("ORD004", "2024-12-11", "11:45 AM", 4000.0, "Paid", "Shipped", "Shipment on the way. Estimated delivery: 2024-12-20")
        );


        orderIdTC.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        datePlacedTC.setCellValueFactory(new PropertyValueFactory<>("datePlaced"));
        timePlacedTC.setCellValueFactory(new PropertyValueFactory<>("timePlaced"));
        totalAmountTC.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        paymentStatusTC.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
        shipmentStatusTC.setCellValueFactory(new PropertyValueFactory<>("shipmentStatus"));


        orderTable.setItems(orders);


        orderTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Order selectedOrder = (Order) newValue;
                orderDetailsLabel.setText("Order ID: " + selectedOrder.getOrderId() +
                        "\nDate Placed: " + selectedOrder.getDatePlaced() +
                        "\nTime Placed: " + selectedOrder.getTimePlaced() +
                        "\nTotal Amount: BDT " + selectedOrder.getTotalAmount());
                shipmentDetailsLabel.setText(selectedOrder.getShipmentDetails());
            }
        });
    }


    private void showOrderDetails(Order order) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/OrderDetailScene.fxml"));
            Parent root = loader.load();

            OrderDetailSceneController controller = loader.getController();
            controller.setOrder(order);

            Stage stage = new Stage();
            stage.setTitle("Order Details");
            stage.setScene(new Scene(root));

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

}
