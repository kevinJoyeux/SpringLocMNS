package LOCMNS.demo.controller.Materiel;

import LOCMNS.demo.dao.Materiel.LieuStockageDao;
import LOCMNS.demo.model.Materiel.LieuStockage;
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
public class LieuStockageController {
    private final LieuStockageDao lieuStockageDao;
    @GetMapping("/lieustockages")
    public List<LieuStockage> getLieuStockage() {

        return lieuStockageDao.findAll();

    }
    @GetMapping("/lieustockage/{id}")
    public ResponseEntity<LieuStockage> getLieuStockage(@PathVariable int id){
        Optional<LieuStockage> existe = lieuStockageDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/lieustockage")
    public ResponseEntity<LieuStockage> ajoutLieuStockage(@RequestBody LieuStockage nouvelleLieuStockage){
        if(nouvelleLieuStockage.getId()!=null){
            Optional<LieuStockage> optional = lieuStockageDao.findById(nouvelleLieuStockage.getId());
            if(optional.isPresent()){
                this.lieuStockageDao.save(nouvelleLieuStockage);
                return new ResponseEntity<>(nouvelleLieuStockage,HttpStatus.OK);
            }
            return new ResponseEntity<>(nouvelleLieuStockage,HttpStatus.BAD_REQUEST);
        }else{
            this.lieuStockageDao.save(nouvelleLieuStockage);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/lieustockage/{id}")
    public ResponseEntity<Utilisateur> supprimeLieuStockage(@PathVariable int id) {
        Optional<LieuStockage> lieustockageAsupprimer = lieuStockageDao.findById(id);
        if (lieustockageAsupprimer.isPresent()) {
            lieuStockageDao.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
