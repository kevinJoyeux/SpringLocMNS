package LOCMNS.demo.dao.Materiel;

import LOCMNS.demo.model.Materiel.LieuStockage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuStockageDao extends JpaRepository<LieuStockage, Integer> {
}
