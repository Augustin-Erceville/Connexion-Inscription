module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens appli.acceuil to javafx.fxml;
    exports appli;
    opens appli to javafx.fxml;
    exports appli.acceuil;
}