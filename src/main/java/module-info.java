module com.example.oop_project_group_8 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.oop_project_group_8 to javafx.fxml;
    exports com.example.oop_project_group_8;

    opens com.example.oop_project_group_8.Mahir_2211582 to javafx.fxml;
    exports com.example.oop_project_group_8.Mahir_2211582;

    opens com.example.oop_project_group_8.Tasin_2211161 to javafx.fxml;
    exports com.example.oop_project_group_8.Tasin_2211161;

    opens com.example.oop_project_group_8.org.example.practice.practice to javafx.fxml;
    exports com.example.oop_project_group_8.org.example.practice.practice;
}
