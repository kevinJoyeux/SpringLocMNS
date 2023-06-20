package LOCMNS.demo.dao.Materiel;


import LOCMNS.demo.model.Materiel.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueDao extends JpaRepository<Marque, Integer> {
}
