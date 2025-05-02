package appli.acceuil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.Utilisateur;
import repository.UtilisateurRepository;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableau;

    @FXML
    private Button supprimerBtn;

    private Utilisateur utilisateurSelectionne;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<Utilisateur, Integer> colId = new TableColumn<>("Identifiant");
        colId.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));

        TableColumn<Utilisateur, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Utilisateur, String> colPrenom = new TableColumn<>("Prénom");
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Utilisateur, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Utilisateur, String> colRole = new TableColumn<>("Rôle");
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));

        tableau.getColumns().addAll(colId, colNom, colPrenom, colEmail, colRole);

        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        List<Utilisateur> utilisateurs = utilisateurRepository.getTousLesUtilisateurs();
        ObservableList<Utilisateur> data = FXCollections.observableArrayList(utilisateurs);
        tableau.setItems(data);

        supprimerBtn.setDisable(true);
    }

    @FXML
    private void cliqueTableauEvent(MouseEvent event) {
        utilisateurSelectionne = tableau.getSelectionModel().getSelectedItem();
        supprimerBtn.setDisable(utilisateurSelectionne == null);
    }

    @FXML
    private void supprimerUtilisateur() {
        if (utilisateurSelectionne != null) {
            UtilisateurRepository repo = new UtilisateurRepository();
            repo.supprimerUtilisateurParEmail(utilisateurSelectionne.getEmail());
            tableau.getItems().remove(utilisateurSelectionne);
            utilisateurSelectionne = null;
            supprimerBtn.setDisable(true);
        }
    }
}
