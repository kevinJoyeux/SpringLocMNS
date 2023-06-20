package LOCMNS.demo.dao.Utilisateur;

import LOCMNS.demo.model.Utilisateur.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByLogin(String login);
    @Query("SELECT u FROM Utilisateur u WHERE u.email=?1")
    List<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByPrenom(String prenom);
    @Query("SELECT u FROM Utilisateur u ORDER BY u.prenom")
    List<Utilisateur> OrderByPrenom();

    @Query("SELECT u from Utilisateur u order by u.nom")
    List<Utilisateur> OrderByNom();

    @Query("SELECT u from Utilisateur u order by u.statut.nomStatut")
    List<Utilisateur> OrderByNomStatut();
    @Query("SELECT u from Utilisateur u order by u.sexe")
    List<Utilisateur> OrderBySexe();

    @Query("SELECT u from Utilisateur u where (u.prenom like %?1%) or (u.nom like %?1%)")
    List<Utilisateur> ChercherUtilisateur(String Recherche);

    List<Utilisateur> findByPrenomAndNom(String prenom, String nom);

    Optional<Utilisateur> findByAffiliation(String affiliation);

    /*@Query("FROM Utilisateur U JOIN U.statut S WHERE S.nomStatut=?1")
    List<Utilisateur> trouveUtilisateurSelonStatut(String nomstatut);*/

}
