module com.example.victusHub {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires java.logging;
    requires org.slf4j;

    opens com.example.victusHub to javafx.fxml;
    exports com.example.victusHub;
}