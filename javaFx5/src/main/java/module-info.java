module com.example.javafx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.javafx5 to javafx.fxml;
    exports com.example.javafx5;
}