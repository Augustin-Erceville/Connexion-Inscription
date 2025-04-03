package appli.acceuil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableau;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[][] colonnes = {
                {"Id Utilisateur", "idUser"},
                {"Nom", "nom"},
                {"Prénom", "prenom"},
                {"Email", "mail"},
                {"Rôle", "role"},
        };

        for (String[] col : colonnes) {
            TableColumn<Utilisateur, String> maCol = new TableColumn<>(col[0]);
            maCol.setCellValueFactory(new PropertyValueFactory<>(col[1]));
            tableau.getColumns().add(maCol);

            UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

            List<Utilisateur> utilisateurs = utilisateurRepository.getTousLesUtilisateurs();
            ObservableList<Utilisateur> data = FXCollections.observableArrayList(utilisateurs);
            tableau.setItems(data);
        }
    }
}