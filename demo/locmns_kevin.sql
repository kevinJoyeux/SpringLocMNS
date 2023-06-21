-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 21 juin 2023 à 09:07
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `locmns`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `nom_categorie`) VALUES
(1, 'ordinateur'),
(2, 'videoproj');

-- --------------------------------------------------------

--
-- Structure de la table `documentation`
--

DROP TABLE IF EXISTS `documentation`;
CREATE TABLE IF NOT EXISTS `documentation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `documentation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `documentation`
--

INSERT INTO `documentation` (`id`, `documentation`) VALUES
(1, 'doc1'),
(2, 'doc2');

-- --------------------------------------------------------

--
-- Structure de la table `etat_materiel`
--

DROP TABLE IF EXISTS `etat_materiel`;
CREATE TABLE IF NOT EXISTS `etat_materiel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `etat_materiel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `etat_materiel`
--

INSERT INTO `etat_materiel` (`id`, `etat_materiel`) VALUES
(1, 'En Etat'),
(2, 'Abime');

-- --------------------------------------------------------

--
-- Structure de la table `lieu_stockage`
--

DROP TABLE IF EXISTS `lieu_stockage`;
CREATE TABLE IF NOT EXISTS `lieu_stockage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lieu_stockage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `lieu_stockage`
--

INSERT INTO `lieu_stockage` (`id`, `lieu_stockage`) VALUES
(1, 'MNS'),
(2, 'IFA');

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_debut_location_prevue` date DEFAULT NULL,
  `date_decision` date DEFAULT NULL,
  `date_demande_location` date DEFAULT NULL,
  `date_fin_location_prevue` date DEFAULT NULL,
  `date_location_etat` date DEFAULT NULL,
  `date_prolongation` date DEFAULT NULL,
  `date_validation_prolongation` date DEFAULT NULL,
  `decision` bit(1) DEFAULT NULL,
  `raison_location` varchar(255) DEFAULT NULL,
  `utilisateur_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgg4v64i8iu4r5md5o2uhi06g2` (`utilisateur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`id`, `date_debut_location_prevue`, `date_decision`, `date_demande_location`, `date_fin_location_prevue`, `date_location_etat`, `date_prolongation`, `date_validation_prolongation`, `decision`, `raison_location`, `utilisateur_id`) VALUES
(1, '2023-06-27', '2023-06-29', '2023-06-20', '2023-06-29', '2023-06-23', '2023-06-21', '2023-06-20', b'1', 'louer pour une réunion', 1),
(2, '2023-06-29', '2023-06-21', '2023-06-20', '2023-06-28', '2023-06-25', '2023-06-27', '2023-06-20', b'0', 'louer pour un cours', 1),
(3, '2023-06-20', '2023-06-24', '2023-06-20', '2023-06-21', '2023-06-20', '2023-06-24', '2023-06-20', b'1', 'pas de raison', 3),
(4, '2023-06-27', '2023-06-29', '2023-06-20', '2023-06-29', '2023-06-23', '2023-06-21', '2023-06-20', b'1', 'location cours', 1),
(5, '2023-06-29', '2023-06-21', '2023-06-20', '2023-06-28', '2023-06-25', '2023-06-27', '2023-06-20', b'0', 'location visio', 1),
(6, '2023-06-20', '2023-06-24', '2023-06-20', '2023-06-21', '2023-06-20', '2023-06-24', '2023-06-20', b'0', 'rien', 3);

-- --------------------------------------------------------

--
-- Structure de la table `location_materiel`
--

DROP TABLE IF EXISTS `location_materiel`;
CREATE TABLE IF NOT EXISTS `location_materiel` (
  `location_id` int NOT NULL,
  `materiel_id` int NOT NULL,
  `date_retour_materiel` date DEFAULT NULL,
  `retour` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location_id`,`materiel_id`),
  KEY `FKtpph9bjda6t5o2pmr4dyq0xsp` (`materiel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `location_materiel`
--

INSERT INTO `location_materiel` (`location_id`, `materiel_id`, `date_retour_materiel`, `retour`) VALUES
(1, 1, '2023-06-20', 'Pas content'),
(2, 1, '2023-06-27', 'Pas content'),
(3, 2, '2023-06-20', 'Pas content'),
(4, 2, '2023-06-27', 'Pas content'),
(5, 2, '2023-06-20', 'Pas content'),
(6, 1, '2023-06-27', 'Pas content');

-- --------------------------------------------------------

--
-- Structure de la table `marque`
--

DROP TABLE IF EXISTS `marque`;
CREATE TABLE IF NOT EXISTS `marque` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom_marque` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `marque`
--

INSERT INTO `marque` (`id`, `nom_marque`) VALUES
(1, 'Asus'),
(2, 'Lenovo');

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

DROP TABLE IF EXISTS `materiel`;
CREATE TABLE IF NOT EXISTS `materiel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `matricule` varchar(255) DEFAULT NULL,
  `categorie_id` int DEFAULT NULL,
  `lieu_stockage_id` int DEFAULT NULL,
  `modele_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5bhuwo34yxm173jr9djrp915i` (`categorie_id`),
  KEY `FK7uqyoryk34de7asjlj73u1yt3` (`lieu_stockage_id`),
  KEY `FKasgcqi6j1bksvj4tqs68ve8lw` (`modele_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id`, `matricule`, `categorie_id`, `lieu_stockage_id`, `modele_id`) VALUES
(1, 'lolo', 1, 1, 2),
(2, 'lala', 2, 1, 1),
(3, 'lulu', 1, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `materiel_documentation`
--

DROP TABLE IF EXISTS `materiel_documentation`;
CREATE TABLE IF NOT EXISTS `materiel_documentation` (
  `materiel_id` int NOT NULL,
  `documentation_id` int NOT NULL,
  KEY `FK8bp1lnepxwrp2w8odalje3n6i` (`documentation_id`),
  KEY `FKj0p3jw1gad6l5bsjttrev8ndf` (`materiel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `materiel_documentation`
--

INSERT INTO `materiel_documentation` (`materiel_id`, `documentation_id`) VALUES
(1, 2),
(1, 1),
(1, 1),
(2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `materiel_etat_materiel`
--

DROP TABLE IF EXISTS `materiel_etat_materiel`;
CREATE TABLE IF NOT EXISTS `materiel_etat_materiel` (
  `date_etat_materiel` datetime(6) NOT NULL,
  `idetat` int NOT NULL,
  `idmat` int NOT NULL,
  PRIMARY KEY (`date_etat_materiel`,`idetat`,`idmat`),
  KEY `FKdqslbnlgf0rssd62f5sindanc` (`idetat`),
  KEY `FK4erk0v2vhf9v1hcueyr0mjrg9` (`idmat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `materiel_etat_materiel`
--

INSERT INTO `materiel_etat_materiel` (`date_etat_materiel`, `idetat`, `idmat`) VALUES
('2023-06-20 08:57:36.000000', 1, 1),
('2023-06-20 08:57:36.000000', 1, 2),
('2023-06-27 08:57:36.000000', 1, 2),
('2023-06-27 08:57:36.000000', 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `modele`
--

DROP TABLE IF EXISTS `modele`;
CREATE TABLE IF NOT EXISTS `modele` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `marque_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8y0qsdtgm60haj45cmgypuvf6` (`marque_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `modele`
--

INSERT INTO `modele` (`id`, `nom`, `marque_id`) VALUES
(1, 'test1', 1),
(2, 'test2', 1),
(3, 'test3', 2);

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

DROP TABLE IF EXISTS `statut`;
CREATE TABLE IF NOT EXISTS `statut` (
  `id` int NOT NULL,
  `nom_statut` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `statut`
--

INSERT INTO `statut` (`id`, `nom_statut`) VALUES
(1, 'utilisateur'),
(2, 'administrateur'),
(3, 'intervenant');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `affiliation` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `mot_de_passe` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `portable` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `statut_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtdm9uec1cre023096vuk4smyx` (`statut_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `affiliation`, `email`, `login`, `mot_de_passe`, `nom`, `portable`, `prenom`, `sexe`, `statut_id`) VALUES
(1, 'Metz Numeric School', 'joyeux@kevin.fr', 'lala', '$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q', 'Joyeux', '06.73.29.18.62', 'Kevin', 'M', 1),
(2, 'Metz Numeric School', 'joyeuxkevin@orange.fr', 'lulu', '$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q', 'Schwartz', '06.73.29.18.62', 'Kevin', 'M', 1),
(3, 'Metz Numeric School', 'alizee@schwartz.com', 'alizeeSchwartz', '$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q', 'Schwartz', '06.73.29.18.62', 'Alizee', 'F', 2),
(4, NULL, NULL, NULL, NULL, 'Test', NULL, 'test', NULL, NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `FKgg4v64i8iu4r5md5o2uhi06g2` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `location_materiel`
--
ALTER TABLE `location_materiel`
  ADD CONSTRAINT `FKou1x2r5tm24sgfbxwnefjiox5` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKtpph9bjda6t5o2pmr4dyq0xsp` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD CONSTRAINT `FK5bhuwo34yxm173jr9djrp915i` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK7uqyoryk34de7asjlj73u1yt3` FOREIGN KEY (`lieu_stockage_id`) REFERENCES `lieu_stockage` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKasgcqi6j1bksvj4tqs68ve8lw` FOREIGN KEY (`modele_id`) REFERENCES `modele` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `materiel_documentation`
--
ALTER TABLE `materiel_documentation`
  ADD CONSTRAINT `FK8bp1lnepxwrp2w8odalje3n6i` FOREIGN KEY (`documentation_id`) REFERENCES `documentation` (`id`),
  ADD CONSTRAINT `FKj0p3jw1gad6l5bsjttrev8ndf` FOREIGN KEY (`materiel_id`) REFERENCES `materiel` (`id`);

--
-- Contraintes pour la table `materiel_etat_materiel`
--
ALTER TABLE `materiel_etat_materiel`
  ADD CONSTRAINT `FK4erk0v2vhf9v1hcueyr0mjrg9` FOREIGN KEY (`idmat`) REFERENCES `materiel` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKdqslbnlgf0rssd62f5sindanc` FOREIGN KEY (`idetat`) REFERENCES `etat_materiel` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `modele`
--
ALTER TABLE `modele`
  ADD CONSTRAINT `FK8y0qsdtgm60haj45cmgypuvf6` FOREIGN KEY (`marque_id`) REFERENCES `marque` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FKtdm9uec1cre023096vuk4smyx` FOREIGN KEY (`statut_id`) REFERENCES `statut` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
