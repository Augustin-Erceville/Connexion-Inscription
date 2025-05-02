package appli.acceuil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Utilisateur;
import repository.UtilisateurRepository;

public class ModificationUserController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField roleField;

    @FXML
    private Button boutonValider;

    private Utilisateur utilisateur;

    private UtilisateurRepository utilisateurRepository;

    private TableController tableController;

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        nomField.setText(utilisateur.getNom());
        prenomField.setText(utilisateur.getPrenom());
        emailField.setText(utilisateur.getEmail());
        emailField.setDisable(true);
        roleField.setText(utilisateur.getRole());
    }

    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public void setTableController(TableController tableController) {
        this.tableController = tableController;
    }

    @FXML
    public void initialize() {
        boutonValider.setOnAction(event -> handleModifierUtilisateur());
    }

    @FXML
    private void modifierUtilisateur() {
        handleModifierUtilisateur();
    }

    private void handleModifierUtilisateur() {
        if (utilisateur != null) {
            utilisateur.setNom(nomField.getText());
            utilisateur.setPrenom(prenomField.getText());
            utilisateur.setRole(roleField.getText());

            boolean succes = utilisateurRepository.mettreAJourUtilisateur(utilisateur);
            if (succes) {
                fermerFenetre();
            } else {
                System.err.println("Échec de la mise à jour de l'utilisateur.");
            }
        }
    }

    private void fermerFenetre() {
        Stage stage = (Stage) boutonValider.getScene().getWindow();
        stage.close();
    }
}
