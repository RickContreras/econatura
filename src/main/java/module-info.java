module udea.tecnicas.view {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.web;
    requires java.sql;

    opens udea.tecnicas.view to javafx.fxml;
    opens udea.tecnicas.model to javafx.base;
    exports udea.tecnicas.view;
}