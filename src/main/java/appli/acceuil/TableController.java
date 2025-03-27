package appli.acceuil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import session.SessionUtilisateur;
import repository.UtilisateurRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private TableView<Utilisateur> tableView;
    @FXML
    private TextField identifiant;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String user = identifiant.getText().trim();
        String[][] colonnes = {
                { "Id Utilisateur", "idUser" },
                { "Nom", "nom" },
                { "Prénom", "prenom" },
                { "Email", "mail" },
                { "Rôle", "role" },
        };
        UtilisateurRepository utilisateurRepo = new UtilisateurRepository();
        Utilisateur utilisateur = utilisateurRepo.getUtilisateurParEmail(user);
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Utilisateur, String> maCol = new TableColumn<>(colonnes[i][0]);
            maCol.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
            tableView.getColumns().add(maCol);
        }
    }
}