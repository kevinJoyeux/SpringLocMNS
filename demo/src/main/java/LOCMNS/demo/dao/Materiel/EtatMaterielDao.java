package LOCMNS.demo.dao.Materiel;


import LOCMNS.demo.model.Materiel.EtatMateriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatMaterielDao extends JpaRepository<EtatMateriel, Integer> {
}
