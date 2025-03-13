package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class InscriptionController {

    @FXML
    private Button connexion;

    @FXML
    private TextField email;

    @FXML
    private Label erreurLabel;

    @FXML
    private Button inscription;

    @FXML
    private PasswordField mdp;

    @FXML
    private PasswordField mdp_confirm;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    void validerInscription(ActionEvent event) {
        String nomUtilisateur = nom.getText().trim();
        String prenomUtilisateur = prenom.getText().trim();
        String emailUtilisateur = email.getText().trim();
        String motDePasse = mdp.getText().trim();
        String confirmationMotDePasse = mdp_confirm.getText().trim();
        if (nomUtilisateur.isEmpty() || prenomUtilisateur.isEmpty() || emailUtilisateur.isEmpty() ||
                motDePasse.isEmpty() || confirmationMotDePasse.isEmpty()) {
            erreurLabel.setText("Tous les champs sont obligatoires !");
            return;
        }
        if (!motDePasse.equals(confirmationMotDePasse)) {
            erreurLabel.setText("Les mots de passe ne correspondent pas !");
            return;
        }
        if (!emailUtilisateur.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,6}$")) { //Je vérifie si l'email a un @ et contien les bon caractères
            erreurLabel.setText("Adresse email invalide !");
            return;
        }
        erreurLabel.setText("Inscription réussie !");
        System.out.println("Prénom : " +prenom.getText()+"\nNom : "+nom.getText()+"\nEmail : "+email.getText()+"\nMotDePasse : "+mdp.getText());
    }

    @FXML
    void revenirALogin(ActionEvent event) {
        StartApplication.changeScene("LoginView");
    }
}
