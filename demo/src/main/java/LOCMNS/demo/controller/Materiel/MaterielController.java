package LOCMNS.demo.controller.Materiel;

import LOCMNS.demo.dao.Materiel.MaterielDao;
import LOCMNS.demo.model.Materiel.Materiel;

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
public class MaterielController {

    private final MaterielDao MaterielDao;
    @GetMapping("/materiels") // afficher l'ensemble des materiels
    public List<Materiel> getMateriels() {

        return MaterielDao.findAll();

    }
    @GetMapping("/materiel/{id}") // afficher le materiel selon un id
    public ResponseEntity<Materiel> getMateriel(@PathVariable int id){
        Optional<Materiel> existe = MaterielDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    @PostMapping("/materiel") // ajouter un materiel/MAJ
    public ResponseEntity<Materiel> ajoutMateriel(@RequestBody Materiel nouveauMateriel){
        if(nouveauMateriel.getId()!=null){ //le materiel possède un id
            Optional<Materiel> optional = MaterielDao.findById(nouveauMateriel.getId());
            if(optional.isPresent()){
                this.MaterielDao.save(nouveauMateriel);
                return new ResponseEntity<>(nouveauMateriel,HttpStatus.OK);
            }
            return new ResponseEntity<>(nouveauMateriel,HttpStatus.BAD_REQUEST);
        }else{
            this.MaterielDao.save(nouveauMateriel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/materiel/{id}") // delete un materiel
    public ResponseEntity<Materiel> supprimeMateriel(@PathVariable int id) {
        Optional<Materiel> materielAsupprimer = MaterielDao.findById(id);
        if (materielAsupprimer.isPresent()) {
            MaterielDao.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/materielRecherche/{recherche}")
    public List<Materiel> getMaterielsRecherche(@PathVariable String recherche) {
        if(recherche !=""){
            return MaterielDao.RechercheMateriel(recherche);
        }else{
            return MaterielDao.findAll();
        }
    }
}
