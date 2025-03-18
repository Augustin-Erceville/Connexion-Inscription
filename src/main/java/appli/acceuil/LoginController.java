package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import repository.UtilisateurRepository;
import model.Utilisateur;

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
    private PasswordField motdepasse;

    @FXML
    public void afficherInformations(ActionEvent event) {
        String user = identifiant.getText().trim();
        String pass = motdepasse.getText().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            erreurLabel.setText("Identifiant et mot de passe sont obligatoires !");
            System.out.println("Erreur : " + erreurLabel.getText());
            return;
        }

        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();
        Utilisateur utilisateur = utilisateurRepo.getUtilisateurParEmail(user);

        if (utilisateur != null) {
            erreurLabel.setText("Connexion réussie !");
            System.out.println("Utilisateur connecté : " + utilisateur);
        } else {
            erreurLabel.setText("Identifiant ou mot de passe incorrect !");
            System.out.println("Erreur : " + erreurLabel.getText());
        }
    }

    @FXML
    private void allerAInscription(ActionEvent event) {
        StartApplication.changeScene("InscriptionView");
    }
}
