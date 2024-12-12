package com.example.ms1group8;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class FishTransportationController {


    @FXML
    private TableView<DeliverySchedule> deliveryScheduleTable;

    @FXML
    private TableColumn<DeliverySchedule, String> dateColumn;

    @FXML
    private TableColumn<DeliverySchedule, String> clientColumn;

    @FXML
    private TableColumn<DeliverySchedule, Integer> quantityColumn;

    @FXML
    private TextArea packingDetailsArea;

    @FXML
    private Button coordinateTransportBtn;


    private final ObservableList<DeliverySchedule> deliveryScheduleList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {

        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        clientColumn.setCellValueFactory(cellData -> cellData.getValue().clientProperty());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());


        deliveryScheduleList.add(new DeliverySchedule("2024-12-15", "Client A", 500));
        deliveryScheduleList.add(new DeliverySchedule("2024-12-16", "Client B", 300));
        deliveryScheduleList.add(new DeliverySchedule("2024-12-17", "Client C", 700));


        deliveryScheduleTable.setItems(deliveryScheduleList);
    }


    @FXML
    private void handleCoordinateTransport() {

        System.out.println("Coordinating transportation...");


        String packingDetails = packingDetailsArea.getText();
        System.out.println("Packing Details: " + packingDetails);
    }


    public static class DeliverySchedule {
        private final SimpleStringProperty date;
        private final SimpleStringProperty client;
        private final SimpleIntegerProperty quantity;

        public DeliverySchedule(String date, String client, int quantity) {
            this.date = new SimpleStringProperty(date);
            this.client = new SimpleStringProperty(client);
            this.quantity = new SimpleIntegerProperty(quantity);
        }

        public String getDate() {
            return date.get();
        }

        public String getClient() {
            return client.get();
        }

        public int getQuantity() {
            return quantity.get();
        }

        public SimpleStringProperty dateProperty() {
            return date;
        }

        public SimpleStringProperty clientProperty() {
            return client;
        }

        public SimpleIntegerProperty quantityProperty() {
            return quantity;
        }
    }
}
