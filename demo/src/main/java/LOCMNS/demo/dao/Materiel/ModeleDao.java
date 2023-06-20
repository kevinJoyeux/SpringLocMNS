package LOCMNS.demo.dao.Materiel;


import LOCMNS.demo.model.Materiel.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleDao extends JpaRepository<Modele, Integer> {
}
