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
            System.out.println("Erreur : " + erreurLabel.getText());
            return;
        }

        if (!motDePasse.equals(confirmationMotDePasse)) {
            erreurLabel.setText("Les mots de passe ne correspondent pas !");
            System.out.println("Erreur : " + erreurLabel.getText());
            return;
        }

        if (!emailUtilisateur.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            erreurLabel.setText("Adresse email invalide !");
            System.out.println("Erreur : " + erreurLabel.getText());
            return;
        }
        Utilisateur nouvelUtilisateur = new Utilisateur(nomUtilisateur, prenomUtilisateur, emailUtilisateur, motDePasse, "utilisateur");

        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();
        utilisateurRepo.inscrireUtilisateur(nouvelUtilisateur);

        System.out.println("Utilisateur inscrit avec succès : " + nouvelUtilisateur);
        StartApplication.changeScene("LoginView");
    }

    @FXML
    void revenirALogin(ActionEvent event) {
        StartApplication.changeScene("LoginView");
    }
}