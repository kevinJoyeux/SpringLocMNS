package LOCMNS.demo.controller.Materiel;

import LOCMNS.demo.dao.Materiel.MarqueDao;
import LOCMNS.demo.model.Materiel.Marque;
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
public class MarqueController {
    private final MarqueDao marqueDao;
    @GetMapping("/marques")
    public List<Marque> getMarque() {

        return marqueDao.findAll();

    }
    @GetMapping("/marque/{id}")
    public ResponseEntity<Marque> getMarque(@PathVariable int id){
        Optional<Marque> existe = marqueDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/marque")
    public ResponseEntity<Marque> ajoutMarque(@RequestBody Marque nouvelleMarque){
        if(nouvelleMarque.getId()!=null){
            Optional<Marque> optional = marqueDao.findById(nouvelleMarque.getId());
            if(optional.isPresent()){
                this.marqueDao.save(nouvelleMarque);
                return new ResponseEntity<>(nouvelleMarque,HttpStatus.OK);
            }
            return new ResponseEntity<>(nouvelleMarque,HttpStatus.BAD_REQUEST);
        }else{
            this.marqueDao.save(nouvelleMarque);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/marque/{id}")
    public ResponseEntity<Utilisateur> supprimeMarque(@PathVariable int id) {
        Optional<Marque> marqueAsupprimer = marqueDao.findById(id);
        if (marqueAsupprimer.isPresent()) {
            marqueDao.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
