package LOCMNS.demo.controller.Materiel;

import LOCMNS.demo.dao.Materiel.CategorieDao;
import LOCMNS.demo.model.Materiel.Categorie;
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
public class CategorieController {

    private final CategorieDao categorieDao;
    @GetMapping("/categories")
    public List<Categorie> getCategorie() {

        return categorieDao.findAll();

    }
    @GetMapping("/categorie/{id}")
    public ResponseEntity<Categorie> getCategorie(@PathVariable int id){
        Optional<Categorie> existe = categorieDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/categorie")
    public ResponseEntity<Categorie> ajoutCategorie(@RequestBody Categorie nouvelleCategorie){
        if(nouvelleCategorie.getId()!=null){
            Optional<Categorie> optional = categorieDao.findById(nouvelleCategorie.getId());
            if(optional.isPresent()){
                this.categorieDao.save(nouvelleCategorie);
                return new ResponseEntity<>(nouvelleCategorie,HttpStatus.OK);
            }
            return new ResponseEntity<>(nouvelleCategorie,HttpStatus.BAD_REQUEST);
        }else{
            this.categorieDao.save(nouvelleCategorie);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/categorie/{id}")
    public ResponseEntity<Utilisateur> supprimeCategorie(@PathVariable int id) {
        Optional<Categorie> categorieAsupprimer = categorieDao.findById(id);
        if (categorieAsupprimer.isPresent()) {
            categorieDao.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
