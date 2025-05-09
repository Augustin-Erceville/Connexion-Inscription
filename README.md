# TP Java FX
### LANCER LE PROGRAMME
Veuillez exécuter `src/main/java/appli/StartApplication.java`.  
Inscrivez-vous.  
Puis connectez-vous.  
Vous aurez accès au tableau des utilisateurs.  
### BASE DE DONNÉES
```sql
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+01:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `tp_javafx` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `tp_javafx`;

DROP TABLE IF EXISTS `liste`;
CREATE TABLE IF NOT EXISTS `liste` (
    `id_liste` int NOT NULL AUTO_INCREMENT,
    `nom` varchar(255) NOT NULL,
    PRIMARY KEY (`id_liste`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `tache`;
CREATE TABLE IF NOT EXISTS `tache` (
    `id_tache` int NOT NULL AUTO_INCREMENT,
    `nom` varchar(255) NOT NULL,
    `etat` int NOT NULL,
    `ref_liste` int NOT NULL,
    `ref_type` int NOT NULL,
    PRIMARY KEY (`id_tache`),
    KEY `fk_tache_liste` (`ref_liste`),
    KEY `fk_tache_type` (`ref_type`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
    `id_type` int NOT NULL AUTO_INCREMENT,
    `nom` varchar(255) NOT NULL,
    `code_couleur` varchar(7) NOT NULL,
    PRIMARY KEY (`id_type`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
    `id_utilisateur` int NOT NULL AUTO_INCREMENT,
    `nom` varchar(50) NOT NULL,
    `prenom` varchar(50) NOT NULL,
    `email` varchar(255) NOT NULL,
    `mot_de_passe` varchar(255) NOT NULL,
    `role` varchar(50) NOT NULL,
    PRIMARY KEY (`id_utilisateur`),
    UNIQUE KEY `email` (`email`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `utilisateur_liste`;
CREATE TABLE IF NOT EXISTS `utilisateur_liste` (
    `ref_utilisateur` int NOT NULL,
    `ref_liste` int NOT NULL,
    PRIMARY KEY (`ref_utilisateur`,`ref_liste`),
    KEY `fk_utilisateur_liste_liste` (`ref_liste`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


ALTER TABLE `tache`
    ADD CONSTRAINT `fk_tache_liste` FOREIGN KEY (`ref_liste`) REFERENCES `liste` (`id_liste`),
  ADD CONSTRAINT `fk_tache_type` FOREIGN KEY (`ref_type`) REFERENCES `type` (`id_type`);

ALTER TABLE `utilisateur_liste`
    ADD CONSTRAINT `fk_utilisateur_liste_liste` FOREIGN KEY (`ref_liste`) REFERENCES `liste` (`id_liste`),
  ADD CONSTRAINT `fk_utilisateur_liste_utilisateur` FOREIGN KEY (`ref_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
```
