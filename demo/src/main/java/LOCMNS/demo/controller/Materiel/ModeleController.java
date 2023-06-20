package LOCMNS.demo.controller.Materiel;

import LOCMNS.demo.dao.Materiel.ModeleDao;

import LOCMNS.demo.model.Materiel.Modele;
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
public class ModeleController {
    private final ModeleDao modeleDao;
    @GetMapping("/modeles")
    public List<Modele> getModele() {

        return modeleDao.findAll();

    }
    @GetMapping("/modele/{id}")
    public ResponseEntity<Modele> getModele(@PathVariable int id){
        Optional<Modele> existe = modeleDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/modele")
    public ResponseEntity<Modele> ajoutModele(@RequestBody Modele nouvelleModele){
        if(nouvelleModele.getId()!=null){
            Optional<Modele> optional = modeleDao.findById(nouvelleModele.getId());
            if(optional.isPresent()){
                this.modeleDao.save(nouvelleModele);
                return new ResponseEntity<>(nouvelleModele,HttpStatus.OK);
            }
            return new ResponseEntity<>(nouvelleModele,HttpStatus.BAD_REQUEST);
        }else{
            this.modeleDao.save(nouvelleModele);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/modele/{id}")
    public ResponseEntity<Utilisateur> supprimeModele(@PathVariable int id) {
        Optional<Modele> modeleAsupprimer = modeleDao.findById(id);
        if (modeleAsupprimer.isPresent()) {
            modeleDao.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
