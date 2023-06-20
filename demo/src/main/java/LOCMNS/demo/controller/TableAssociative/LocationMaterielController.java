package LOCMNS.demo.controller.TableAssociative;

import LOCMNS.demo.dao.TableAssociative.LocationMaterielDao;

import LOCMNS.demo.model.TableAssociative.LocationMateriel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@CrossOrigin
public class LocationMaterielController {
    private LocationMaterielDao LocationMaterielDao;
    @Autowired
    public LocationMaterielController(final LocationMaterielDao locationMaterielDao) {
        this.LocationMaterielDao=locationMaterielDao;
    }

    // donne l'ensemble des matériels selon l'id de la location
    @GetMapping("/locationmateriels/{idloc}")
    public Optional<LocationMateriel> getLocationMaterielByIdLocation(@PathVariable Integer idloc) {
        return LocationMaterielDao.findByLocation_id(idloc);

    }

    // retrouve la location et l'id concordant
    @GetMapping("/locationmateriels/{idloc}/{idmat}")
    public Optional<LocationMateriel> getLocationMateriels(@PathVariable Integer idloc, @PathVariable Integer idmat) {
        return LocationMaterielDao.findByLocation_idAndMateriel_id(idloc,idmat);

    }
    @PostMapping("/locationmateriel") //
    public ResponseEntity ajoutUtilisateur(@RequestBody LocationMateriel locationMateriel){
        if((locationMateriel.getMateriel_id()!=null)&&(locationMateriel.getLocation_id()!=null)&&locationMateriel.getDateRetourMateriel()!=null){
            Optional<LocationMateriel> optional = LocationMaterielDao.findByLocation_idAndMateriel_id(locationMateriel.getLocation_id(),locationMateriel.getMateriel_id());
            if(optional.isPresent()){
                this.LocationMaterielDao.save(locationMateriel);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            this.LocationMaterielDao.save(locationMateriel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
   @DeleteMapping("/locationmateriel")
   @Transactional
    public ResponseEntity<LocationMateriel> supprimeLocationMateriel(@RequestBody LocationMateriel locationMateriel) {
        Optional<LocationMateriel> locationMaterielAsupprimer = LocationMaterielDao.findByLocation_idAndMateriel_id(locationMateriel.getLocation_id(), locationMateriel.getMateriel_id());
        if(locationMaterielAsupprimer.isPresent()){
            LocationMaterielDao.deleteByLocation_idAndMateriel_idAndDateRetourMateriel(locationMateriel.getLocation_id(), locationMateriel.getMateriel_id(),locationMateriel.getDateRetourMateriel());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
