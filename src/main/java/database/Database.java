package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String SERVEUR = "localhost";
    private static final String NOM_BDD = "tp_javafx";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "";

    private static String getUrl() {
        return "jdbc:mysql://" + SERVEUR + "/" + NOM_BDD + "?serverTimezone=UTC";
    }

    public static Connection getConnexion() {
        Connection cnx = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(getUrl(), UTILISATEUR, MOT_DE_PASSE);
            System.out.println("Connexion réussie à la base de données !");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : Driver JDBC non trouvé !");
        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }

        if (cnx == null) {
            System.err.println("Impossible de se connecter à la base de données.");
        }
        return cnx;
    }
}
