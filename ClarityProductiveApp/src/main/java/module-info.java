module com.clarity.clarityproductiveapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;

    opens com.clarity.clarityproductiveapp to javafx.fxml;
    exports com.clarity.clarityproductiveapp;
}