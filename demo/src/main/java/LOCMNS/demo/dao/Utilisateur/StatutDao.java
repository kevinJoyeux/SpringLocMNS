package LOCMNS.demo.dao.Utilisateur;

import LOCMNS.demo.model.Utilisateur.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatutDao extends JpaRepository<Statut, Integer> {
    Optional<Statut> findByNomStatut(String nomStatut);
}
