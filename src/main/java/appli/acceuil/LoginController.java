package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UtilisateurRepository;
import session.SessionUtilisateur;
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
        BCryptPasswordEncoder myEncoder = new BCryptPasswordEncoder();
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();
        Utilisateur utilisateur = utilisateurRepo.getUtilisateurParEmail(user);

        if (utilisateur != null && myEncoder.matches(motdepasse.getText(), utilisateur.getMot_de_passe())) {
            erreurLabel.setText("Connexion réussie !\nBienvenue\n" + utilisateur.getPrenom() + " " + utilisateur.getNom());
            System.out.println("Utilisateur connecté : " + utilisateur);
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
