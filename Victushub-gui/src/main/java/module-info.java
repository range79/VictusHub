module com.range.victusHub {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires java.logging;
    requires org.slf4j;

    opens com.range.victusHub to javafx.fxml;
    exports com.range.victusHub;
    exports com.range.victusHub.fan;
    opens com.range.victusHub.fan to javafx.fxml;
}