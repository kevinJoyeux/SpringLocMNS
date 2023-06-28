package LOCMNS.demo.dao.Location;

import LOCMNS.demo.model.Location.Location;
import LOCMNS.demo.model.Utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LocationDao extends JpaRepository<Location, Integer> {
    List<Location> findByDecisionTrue();
    @Query("SELECT l from Location l where l.decision=false")
    List<Location> findByDecisionFalse();

    @Query("SELECT l from Location l where l.utilisateur.id=?1 and l.decision=false")
    List<Location> findByUtilisateurIdAndDecisionFalse(Integer id);

    @Query ("select l from Location l where l.utilisateur.id=?1 and l.decision=true")
    List<Location> findByUtilisateurIdAndDecisionTrue(Integer id);

    @Query("SELECT DISTINCT u from Utilisateur u inner join Location l on l.utilisateur.id=u.id where l.utilisateur.id=?1")
    Utilisateur findByLocation_id(Integer id);

    @Query("SELECT l from Location l where l.decision=false order by l.dateDebutLocationPrevue ")
    List<Location> OrderByDateDebutLocationPrevue();

    @Query("SELECT l from Location l where l.decision=false order by l.dateFinLocationPrevue")
    List<Location> OrderByDateFinLocationPrevue();

    @Query("SELECT l from Location l where l.decision=false order by l.dateProlongation")
    List<Location> OrderByDateProlongation();

    @Query("Select l from Location l where l.decision=false order by l.dateDecision")
    List<Location> OrderByDateDecision();
}
