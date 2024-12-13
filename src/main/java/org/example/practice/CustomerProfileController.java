package org.example.practice;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CustomerProfileController {

    @FXML private TextField searchField;
    @FXML private TableView<CustomerProfile> customerDetailsTable;
    @FXML private TableColumn<CustomerProfile, String> fieldColumn;
    @FXML private TableColumn<CustomerProfile, String> valueColumn;
    @FXML private ComboBox<String> profileReportComboBox;
    @FXML private Button updateProfileButton;

    private ObservableList<CustomerProfile> customerData;

    public void initialize() {

        fieldColumn.setCellValueFactory(cellData -> cellData.getValue().fieldProperty());
        valueColumn.setCellValueFactory(cellData -> cellData.getValue().valueProperty());


        profileReportComboBox.setItems(FXCollections.observableArrayList("Summary Report", "Detailed Report"));


        customerData = FXCollections.observableArrayList();
        customerDetailsTable.setItems(customerData);


        customerData.add(new CustomerProfile("Name", "John Doe"));
        customerData.add(new CustomerProfile("Email", "john.doe@example.com"));
        customerData.add(new CustomerProfile("Phone", "+123456789"));
        customerData.add(new CustomerProfile("Name", "Li Wei"));
        customerData.add(new CustomerProfile("Email", "li.wei@example.cn"));
        customerData.add(new CustomerProfile("Phone", "+8613800138000"));

        customerData.add(new CustomerProfile("Name", "Ananya Sharma"));
        customerData.add(new CustomerProfile("Email", "ananya.sharma@example.in"));
        customerData.add(new CustomerProfile("Phone", "+919876543210"));

        customerData.add(new CustomerProfile("Name", "Hiroshi Tanaka"));
        customerData.add(new CustomerProfile("Email", "hiroshi.tanaka@example.jp"));
        customerData.add(new CustomerProfile("Phone", "+819012345678"));

        customerData.add(new CustomerProfile("Name", "Chul Min Park"));
        customerData.add(new CustomerProfile("Email", "chulmin.park@example.kr"));
        customerData.add(new CustomerProfile("Phone", "+821012345678"));

        customerData.add(new CustomerProfile("Name", "Ayesha Khan"));
        customerData.add(new CustomerProfile("Email", "ayesha.khan@example.pk"));
        customerData.add(new CustomerProfile("Phone", "+923001234567"));

        customerData.add(new CustomerProfile("Name", "Mai Nguyen"));
        customerData.add(new CustomerProfile("Email", "mai.nguyen@example.vn"));
        customerData.add(new CustomerProfile("Phone", "+849012345678"));

        customerData.add(new CustomerProfile("Name", "Chen Xiaoming"));
        customerData.add(new CustomerProfile("Email", "chen.xiaoming@example.cn"));
        customerData.add(new CustomerProfile("Phone", "+8615912345678"));

        customerData.add(new CustomerProfile("Name", "Siti Nurhaliza"));
        customerData.add(new CustomerProfile("Email", "siti.nurhaliza@example.my"));
        customerData.add(new CustomerProfile("Phone", "+60123234567"));

        customerData.add(new CustomerProfile("Name", "Ravi Patel"));
        customerData.add(new CustomerProfile("Email", "ravi.patel@example.in"));
        customerData.add(new CustomerProfile("Phone", "+919876543211"));

        customerData.add(new CustomerProfile("Name", "Satoshi Suzuki"));
        customerData.add(new CustomerProfile("Email", "satoshi.suzuki@example.jp"));
        customerData.add(new CustomerProfile("Phone", "+819013456789"));

        customerData.add(new CustomerProfile("Name", "Zhang Wei"));
        customerData.add(new CustomerProfile("Email", "zhang.wei@example.cn"));
        customerData.add(new CustomerProfile("Phone", "+8613500123456"));

        customerData.add(new CustomerProfile("Name", "Kim Ji-ho"));
        customerData.add(new CustomerProfile("Email", "kim.jiho@example.kr"));
        customerData.add(new CustomerProfile("Phone", "+821234567890"));

        customerData.add(new CustomerProfile("Name", "Pooja Desai"));
        customerData.add(new CustomerProfile("Email", "pooja.desai@example.in"));
        customerData.add(new CustomerProfile("Phone", "+919887654321"));

        customerData.add(new CustomerProfile("Name", "Hassan Ali"));
        customerData.add(new CustomerProfile("Email", "hassan.ali@example.pk"));
        customerData.add(new CustomerProfile("Phone", "+923001234567"));

        customerData.add(new CustomerProfile("Name", "Takahiro Yamamoto"));
        customerData.add(new CustomerProfile("Email", "takahiro.yamamoto@example.jp"));
        customerData.add(new CustomerProfile("Phone", "+819014567890"));
    }

    @FXML
    private void searchCustomer() {
        String searchText = searchField.getText().toLowerCase();
        ObservableList<CustomerProfile> filteredData = FXCollections.observableArrayList();

        for (CustomerProfile customer : customerData) {
            if (customer.getField().toLowerCase().contains(searchText) ||
                    customer.getValue().toLowerCase().contains(searchText)) {
                filteredData.add(customer);
            }
        }

        customerDetailsTable.setItems(filteredData);
    }

    @FXML
    private void generateReport() {
        String selectedReport = profileReportComboBox.getSelectionModel().getSelectedItem();
        if (selectedReport != null) {
            System.out.println("Generating: " + selectedReport);

        }
    }

    @FXML
    private void updateProfile() {
        System.out.println("Profile updated!");

    }


    public static class CustomerProfile {
        private final StringProperty field;
        private final StringProperty value;

        public CustomerProfile(String field, String value) {
            this.field = new SimpleStringProperty(field);
            this.value = new SimpleStringProperty(value);
        }

        public StringProperty fieldProperty() {
            return field;
        }

        public StringProperty valueProperty() {
            return value;
        }

        public String getField() {
            return field.get();
        }

        public String getValue() {
            return value.get();
        }

        public void setField(String field) {
            this.field.set(field);
        }

        public void setValue(String value) {
            this.value.set(value);
        }
    }
}
