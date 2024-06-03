module com.example.echecsae {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.echecsae to javafx.fxml;
    exports com.example.echecsae;
}