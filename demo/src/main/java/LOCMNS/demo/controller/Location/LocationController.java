package LOCMNS.demo.controller.Location;

import LOCMNS.demo.dao.Location.LocationDao;
import LOCMNS.demo.model.Location.Location;
import LOCMNS.demo.model.Utilisateur.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
@AllArgsConstructor
public class LocationController {
    private final LocationDao locationDao;
    @GetMapping("/location")
    public List<Location> getLocation() {

        return locationDao.findAll();

    }
    @GetMapping("/location/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable int id){
        Optional<Location> existe = locationDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/locationvalidee")
    public List<Location> getLocationvalidee(){
        return locationDao.findByDecisionTrue();
    }
    @GetMapping("/locationattente")
    public List<Location> getLocationattente(){
        return locationDao.findByDecisionFalse();
    }
    @PostMapping("/location")
    public ResponseEntity<Location> ajoutLocation(@RequestBody Location nouvelleLocation){
        String date = nouvelleLocation.getDateDemandeLocation().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate localDate = LocalDate.parse(date, formatter);
        nouvelleLocation.setDateDemandeLocation(localDate);
        if(nouvelleLocation.getId()!=null){
            Optional<Location> optional = locationDao.findById(nouvelleLocation.getId());
            if(optional.isPresent()){
                this.locationDao.save(nouvelleLocation);
                return new ResponseEntity<>(nouvelleLocation,HttpStatus.OK);
            }
            return new ResponseEntity<>(nouvelleLocation,HttpStatus.BAD_REQUEST);
        }else{
            this.locationDao.save(nouvelleLocation);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/location/{id}")
    public ResponseEntity<Utilisateur> supprimeLocation(@PathVariable int id) {
        Optional<Location> locationAsupprimer = locationDao.findById(id);
        if (locationAsupprimer.isPresent()) {
            locationDao.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // tri selon paramètres
    @GetMapping("/locationDateDebutPrevue")
    public List<Location> OrderByDateDebutLocationPrevue(){
        return locationDao.OrderByDateDebutLocationPrevue();
    }
    @GetMapping("/locationDateFinPrevue")
    public List<Location> OrderByDateFinLocationPrevue(){
        return locationDao.OrderByDateFinLocationPrevue();
    }
    @GetMapping("/locationDateProlongation")
    public List<Location> OrderByDateProlongation(){
        return locationDao.OrderByDateProlongation();
    }
    @GetMapping("/locationDateDecision")
    public List<Location> OrderByDateDecision(){
        return locationDao.OrderByDateDecision();
    }

    // renvoit l'utilisateur selon l'id de la location
    @GetMapping("/locationUtilisateur/{idloc}")
    public Utilisateur findByLocation_id(@PathVariable int idloc){
        return locationDao.findByLocation_id(idloc);
    }

    // permet à une location de changer sa "décision" en true
    @GetMapping("locationvalide/{id}")
        public ResponseEntity<Location> LocationValide(@PathVariable Integer id){
        if(id != null){
            Optional<Location> optional = locationDao.findById(id);
            if(optional.isPresent()){
                Location save = optional.get();
                save.setDecision(true);
                this.locationDao.save(save);
                return new ResponseEntity<>(save,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // décision -> false
    @GetMapping("locationrefusee/{id}")
    public ResponseEntity<Location> LocationRefusee(@PathVariable Integer id){
        if(id != null){
            Optional<Location> optional = locationDao.findById(id);
            if(optional.isPresent()){
                Location save = optional.get();
                save.setDecision(false);
                this.locationDao.save(save);
                return new ResponseEntity<>(save,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // selon notre utilisateur, renvoit la liste dont la décision est true ou false
    @GetMapping("locationutilisateurfalse/{id}")
    public List<Location> LocationUtilisateurfalse(@PathVariable Integer id){
        return locationDao.findByUtilisateurIdAndDecisionFalse(id);
    }
    @GetMapping("locationutilisateurtrue/{id}")
    public List<Location> LocationUtilisateurtrue(@PathVariable Integer id){
        return locationDao.findByUtilisateurIdAndDecisionTrue(id);
    }


}
