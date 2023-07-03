package LOCMNS.demo.controller.Materiel;

import LOCMNS.demo.dao.Materiel.EtatMaterielDao;
import LOCMNS.demo.model.Materiel.EtatMateriel;
import LOCMNS.demo.model.Utilisateur.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
@AllArgsConstructor
public class EtatMaterielController {
    private final EtatMaterielDao etatMaterielDao;
    @GetMapping("/etatmateriels")
    public List<EtatMateriel> getEtatMateriel() {

        return etatMaterielDao.findAll();

    }
    @GetMapping("/etatmateriel/{id}")
    public ResponseEntity<EtatMateriel> getEtatMateriel(@PathVariable int id){
        Optional<EtatMateriel> existe = etatMaterielDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
