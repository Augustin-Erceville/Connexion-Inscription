package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class StartApplication extends Application {
    private static Stage mainStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/appli/acceuil/LoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setTitle("Connexion");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(String fichierFxml) {
        if (mainStage == null) {
            System.err.println("Erreur : La scène principale n'est pas initialisée.");
            return;
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("/appli/acceuil/" + fichierFxml + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            mainStage.setScene(scene);
            mainStage.setTitle(fichierFxml.equals("LoginView") ? "Connexion" : "Inscription");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur : Impossible de charger " + fichierFxml);
        }
    }
}