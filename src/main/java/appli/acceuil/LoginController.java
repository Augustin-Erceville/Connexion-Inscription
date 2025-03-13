package appli.acceuil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import org.w3c.dom.ls.LSOutput;

public class LoginController {
    @FXML
    private TextField identifiant;

    @FXML
    private TextField motdepasse;

    @FXML
    private DialogPane error;

    @FXML
    private Button connexion;

    @FXML
    private Button inscription;

    @FXML
    private Button mdpoublie;

    public void afficherInformations() {
        String id = identifiant.getText();
        String mdp = motdepasse.getText();

        System.out.println("Identifiant : " + id);
        System.out.println("Mot de passe : " + mdp);
    }

}