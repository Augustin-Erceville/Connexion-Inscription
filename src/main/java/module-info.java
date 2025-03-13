module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens appli.todolistfx to javafx.fxml;
    exports appli.todolistfx;
}