INSERT INTO `Statut` (`id`, `nom_statut`) values (1, 'utilisateur'), (2,'administrateur'),(3,'intervenant');
INSERT INTO `Utilisateur` (`nom`, `prenom`, `email`, `mot_de_passe`, `login`, `sexe`, `affiliation`, `portable`, `statut_id`) values ("Joyeux","Kevin","joyeux@kevin.fr","$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q","lala","M","Metz Numeric School","06.73.29.18.62",1),
                                                                                                                                     ("Schwartz","Kevin","joyeuxkevin@orange.fr","$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q","lulu","M","Metz Numeric School","06.73.29.18.62",1),
                                                                                                                                     ("Schwartz","Alizee","alizee@schwartz.com","$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q","alizeeSchwartz","F","Metz Numeric School","06.73.29.18.62",2);
Insert INTO `Lieu_Stockage` values (1, "MNS"),
                                   (2,"IFA");
INSERT INTO `Categorie` values (1, "ordinateur"),
                               (2,"videoproj");
INSERT INTO `Marque` values (1,"Asus"),
                            (2,"Lenovo");
INSERT INTO `Documentation` values (1,"doc1"),
                                   (2,"doc2");
INSERT INTO `Modele` (`id`, `nom`, `marque_id`) values (1, "test1",1),
                                                       (2,"test2",1),
                                                       (3,"test3",2);
INSERT INTO `Materiel`(`id`, `matricule`, `categorie_id`, `lieu_stockage_id`, `modele_id`) VALUES (1,"lolo",1,1,2),
                                                                                                  (2,"lala",2,1,1),
                                                                                                  (3,"lulu",1,2,3);
INSERT INTO `Materiel_Documentation` VALUES (1,2),
                                            (1,1),
                                            (1,1),
                                            (2,1);
INSERT INTO `Location` values (1,DATE_ADD(UTC_TIMESTAMP(), INTERVAL 7 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 9 DAY),UTC_TIMESTAMP(),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 9 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 3 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 1 DAY),UTC_TIMESTAMP(),true,"louer pour blabla",1),
                              (2,DATE_ADD(UTC_TIMESTAMP(), INTERVAL 9 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 1 DAY),UTC_TIMESTAMP(),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 8 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 5 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 7 DAY),UTC_TIMESTAMP(),false,"louer pour bla",1),
                              (3,DATE(UTC_TIMESTAMP()),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 4 DAY),UTC_TIMESTAMP(),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 1 DAY),UTC_TIMESTAMP(),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 4 DAY),UTC_TIMESTAMP(),true,"louer pour rien",3),
                              (4,DATE_ADD(UTC_TIMESTAMP(), INTERVAL 7 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 9 DAY),UTC_TIMESTAMP(),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 9 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 3 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 1 DAY),UTC_TIMESTAMP(),true,"louer pour blabla",1),
                              (5,DATE_ADD(UTC_TIMESTAMP(), INTERVAL 9 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 1 DAY),UTC_TIMESTAMP(),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 8 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 5 DAY),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 7 DAY),UTC_TIMESTAMP(),false,"louer pour bla",1),
                              (6,DATE(UTC_TIMESTAMP()),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 4 DAY),UTC_TIMESTAMP(),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 1 DAY),UTC_TIMESTAMP(),DATE_ADD(UTC_TIMESTAMP(), INTERVAL 4 DAY),UTC_TIMESTAMP(),false,"louer pour rien",3);


INSERT INTO `Etat_Materiel` values (1,"En Etat"),
                                   (2,"Abime");
INSERT INTO `Materiel_Etat_Materiel` VALUES (UTC_TIMESTAMP(),1,1), (UTC_TIMESTAMP(),1,2),(DATE_ADD(UTC_TIMESTAMP(), INTERVAL 7 DAY),1,3),(DATE_ADD(UTC_TIMESTAMP(), INTERVAL 7 DAY),1,2);
INSERT INTO `location_materiel`(`location_id`, `materiel_id`, `date_retour_materiel`, `retour`) VALUES (1,1,UTC_TIMESTAMP(),"Pas content"),
                                                                                                       (2,1,DATE_ADD(UTC_TIMESTAMP(), INTERVAL 7 DAY),"Pas content"),
                                                                                                       (3,2,UTC_TIMESTAMP(),"Pas content"),
                                                                                                       (4,2,DATE_ADD(UTC_TIMESTAMP(), INTERVAL 7 DAY),"Pas content"),
                                                                                                       (5,2,UTC_TIMESTAMP(),"Pas content"),
                                                                                                       (6,1,DATE_ADD(UTC_TIMESTAMP(), INTERVAL 7 DAY),"Pas content");
SET time_zone = '+00:00';


