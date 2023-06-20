package LOCMNS.demo.dao.Materiel;

import LOCMNS.demo.model.Materiel.Documentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentationDao extends JpaRepository<Documentation, Integer> {
}
