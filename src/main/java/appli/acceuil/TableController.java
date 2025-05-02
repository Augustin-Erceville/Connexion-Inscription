package appli.acceuil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableau;

    @FXML
    private Button supprimerBtn;

    private Utilisateur utilisateurSelectionne;

    private final UtilisateurRepository repo = new UtilisateurRepository();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<Utilisateur, Integer> colId = new TableColumn<>("Id Utilisateur");
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

        List<Utilisateur> utilisateurs = repo.getTousLesUtilisateurs();
        ObservableList<Utilisateur> data = FXCollections.observableArrayList(utilisateurs);
        tableau.setItems(data);

        supprimerBtn.setDisable(true);
    }

    @FXML
    void cliqueTableauEvent(MouseEvent event) {
        utilisateurSelectionne = tableau.getSelectionModel().getSelectedItem();
        supprimerBtn.setDisable(utilisateurSelectionne == null);

        if (event.getClickCount() == 2 && utilisateurSelectionne != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appli/acceuil/modificationUserView.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(loader.load()));

                ModificationUserController controller = loader.getController();
                controller.setUtilisateur(utilisateurSelectionne);
                controller.setUtilisateurRepository(repo);
                controller.setTableController(this);
                stage.showAndWait();
                rafraichirTable();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void supprimerUtilisateur() {
        if (utilisateurSelectionne != null) {
            boolean reussite = repo.supprimerUtilisateurParEmail(utilisateurSelectionne.getEmail());
            if (reussite) {
                rafraichirTable();
                supprimerBtn.setDisable(true);
            }
        }
    }
    public void rafraichirTable() {
        List<Utilisateur> utilisateurs = repo.getTousLesUtilisateurs();
        tableau.getItems().setAll(utilisateurs);
    }
}
