module org.example.practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.practice to javafx.fxml;
    exports org.example.practice;
}