package LOCMNS.demo.controller.Utilisateur;


import LOCMNS.demo.dao.Utilisateur.StatutDao;
import LOCMNS.demo.model.Utilisateur.Statut;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
@AllArgsConstructor
public class StatutController {

    private final StatutDao statutDao;
    @GetMapping("/statuts") 
    public List<Statut> getStatuts() {

        return statutDao.findAll();

    }
    @GetMapping("/statut/{id}")
    public ResponseEntity<Statut> getStatut(@PathVariable int id){
        Optional<Statut> existe = statutDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/statut")
    public ResponseEntity<Statut> ajoutStatut(@RequestBody Statut nouveauStatut){
        if(nouveauStatut.getId()!=null){ // le statut possède un id
            Optional<Statut> optional = statutDao.findById(nouveauStatut.getId());
            if(optional.isPresent()){
                this.statutDao.save(nouveauStatut);
                return new ResponseEntity<>(nouveauStatut,HttpStatus.OK);
            }
            return new ResponseEntity<>(nouveauStatut,HttpStatus.BAD_REQUEST);
        }else{
            this.statutDao.save(nouveauStatut);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/statut/{id}")
    public ResponseEntity<Statut> supprimeStatut(@PathVariable int id) {
        Optional<Statut> statutAsupprimer = statutDao.findById(id);
        if (statutAsupprimer.isPresent()) {
            statutDao.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
