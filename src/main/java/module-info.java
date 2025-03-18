module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens appli.acceuil to javafx.fxml;
    opens model to javafx.base;
    exports appli;
    exports appli.acceuil;
}
