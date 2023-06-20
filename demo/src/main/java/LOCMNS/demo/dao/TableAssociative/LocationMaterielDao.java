package LOCMNS.demo.dao.TableAssociative;

import LOCMNS.demo.model.Materiel.CleLocationMateriel;
import LOCMNS.demo.model.TableAssociative.LocationMateriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LocationMaterielDao extends JpaRepository<LocationMateriel, CleLocationMateriel> {

    @Query("SELECT lm from LocationMateriel lm where lm.materiel_id=?1 and lm.location_id=?2")
    Optional<LocationMateriel> findByLocation_idAndMateriel_id(Integer materielId, Integer locationId);

    @Query("SELECT lm from LocationMateriel lm where lm.location_id=?1")
    Optional<LocationMateriel> findByLocation_id(Integer locationid);
@Modifying
    @Query("DELETE from LocationMateriel lm where lm.materiel_id=?1 and lm.location_id=?2 and lm.DateRetourMateriel=?3")
    void deleteByLocation_idAndMateriel_idAndDateRetourMateriel(Integer locationId, Integer materielId, LocalDate dateRetourMateriel);
}

