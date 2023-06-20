package LOCMNS.demo.controller.Materiel;

import LOCMNS.demo.dao.Materiel.DocumentationDao;
import LOCMNS.demo.model.Materiel.Documentation;
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
public class DocumentationController {
    private final DocumentationDao documentationDao;
    @GetMapping("/documentations")
    public List<Documentation> getDocumentation() {

        return documentationDao.findAll();

    }
    @GetMapping("/documentation/{id}")
    public ResponseEntity<Documentation> getDocumentation(@PathVariable int id){
        Optional<Documentation> existe = documentationDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/documentation")
    public ResponseEntity<Documentation> ajoutDocumentation(@RequestBody Documentation nouvelleDocumentation){
        if(nouvelleDocumentation.getId()!=null){
            Optional<Documentation> optional = documentationDao.findById(nouvelleDocumentation.getId());
            if(optional.isPresent()){
                this.documentationDao.save(nouvelleDocumentation);
                return new ResponseEntity<>(nouvelleDocumentation,HttpStatus.OK);
            }
            return new ResponseEntity<>(nouvelleDocumentation,HttpStatus.BAD_REQUEST);
        }else{
            this.documentationDao.save(nouvelleDocumentation);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/documentation/{id}")
    public ResponseEntity<Utilisateur> supprimeDocumentation(@PathVariable int id) {
        Optional<Documentation> documentationAsupprimer = documentationDao.findById(id);
        if (documentationAsupprimer.isPresent()) {
            documentationDao.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
