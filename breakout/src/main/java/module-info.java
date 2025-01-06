module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    requires transitive javafx.graphics;

    exports com.example;
    opens com.example to javafx.fxml;
}
