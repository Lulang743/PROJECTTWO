module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;


    opens com.example.project to javafx.fxml;
    exports com.example.project;
}