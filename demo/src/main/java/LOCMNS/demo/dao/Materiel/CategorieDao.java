package LOCMNS.demo.dao.Materiel;


import LOCMNS.demo.model.Materiel.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie, Integer> {
}
