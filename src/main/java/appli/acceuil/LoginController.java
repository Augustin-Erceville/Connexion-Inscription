package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginController {

    @FXML
    private Button connexion;

    @FXML
    private Label erreurLabel;

    @FXML
    private TextField identifiant;

    @FXML
    private Button inscription;

    @FXML
    private Button mdp_oublie;

    @FXML
    private TextField motdepasse;

    @FXML
    public void afficherInformations(ActionEvent event) {
        String user = identifiant.getText().trim();
        String pass = motdepasse.getText().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            erreurLabel.setText("Identifiant et mot de passe sont obligatoires !");
            return;
        }
        if (user.equals("admin") && pass.equals("1234")) {
            erreurLabel.setText("Connexion réussie !");
            System.out.println("Identifiant : " +identifiant.getText()+"\nMot de passe : "+motdepasse.getText());
        } else {
            erreurLabel.setText("Identifiant ou mot de passe incorrect !");
        }
    }
    @FXML
    private void allerAInscription(ActionEvent event) {
        StartApplication.changeScene("InscriptionView");
    }
}
