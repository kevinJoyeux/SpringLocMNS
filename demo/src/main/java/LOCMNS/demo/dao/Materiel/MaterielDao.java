package LOCMNS.demo.dao.Materiel;

import LOCMNS.demo.model.Materiel.EtatMateriel;
import LOCMNS.demo.model.Materiel.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

@Repository
public interface MaterielDao extends JpaRepository<Materiel, Integer> {
    Optional<Materiel> findByMatricule(String matricule);

    @Query("SELECT m from Materiel m where (m.categorie.nomCategorie like %?1%) or (m.matricule like %?1%) or (m.modele.nom like %?1%) or (m.lieuStockage.LieuStockage like %?1%)")
    List<Materiel> RechercheMateriel(String texte);
}
