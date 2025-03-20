package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Utilisateur;
import repository.UtilisateurRepository;

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
    private PasswordField motdepasse;

    @FXML
    public void afficherInformations(ActionEvent event) {
        String email = identifiant.getText().trim();
        String motDePasse = motdepasse.getText().trim();

        if (email.isEmpty() || motDePasse.isEmpty()) {
            erreurLabel.setText("Identifiant et mot de passe sont obligatoires !");
            System.out.println("Erreur : " + erreurLabel.getText());
            return;
        }

        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();
        boolean estValide = utilisateurRepo.verifierConnexion(email, motDePasse);

        if (estValide) {
            erreurLabel.setText("Connexion réussie !");
            System.out.println("Utilisateur connecté : " + email);
            StartApplication.changeScene("AcceuilView");
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
