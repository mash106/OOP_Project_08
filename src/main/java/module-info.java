module com.example.ms1group8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ms1group8 to javafx.fxml;
    exports com.example.ms1group8;
}