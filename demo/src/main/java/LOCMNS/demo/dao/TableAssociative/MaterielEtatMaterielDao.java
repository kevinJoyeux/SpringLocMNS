package LOCMNS.demo.dao.TableAssociative;

import LOCMNS.demo.model.Materiel.CleMaterielEtatMateriel;
import LOCMNS.demo.model.TableAssociative.MaterielEtatMateriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterielEtatMaterielDao extends JpaRepository<MaterielEtatMateriel, CleMaterielEtatMateriel> {
Optional<MaterielEtatMateriel> findByIdetatAndIdmat(int idetat, int idmat);
}
