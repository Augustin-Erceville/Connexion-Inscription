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
import java.util.ArrayList;
import java.util.ResourceBundle;

    public class TableController implements Initializable {
        @FXML
        private TableView<Utilisateur> tableau;


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            String[][] colonnes = {
                    { "Id Utilisateur", "id_utilisateur" },
                    { "Nom", "nom" },
                    { "Prénom", "prenom" },
                    { "Email", "email" },
                    { "Rôle", "role" },
            };

            for (int i = 0; i < colonnes.length; i++) {
                TableColumn<Utilisateur, String> maCol = new TableColumn<>(colonnes[i][0]);
                maCol.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
                tableau.getColumns().add(maCol);
            }
            UtilisateurRepository utilisateurRepo = new UtilisateurRepository();
            ArrayList<Utilisateur> utilisateurs = utilisateurRepo.getTousLesUtilisateurs();



        }
    }