package LOCMNS.demo.controller.TableAssociative;

import LOCMNS.demo.dao.TableAssociative.MaterielEtatMaterielDao;

import LOCMNS.demo.model.TableAssociative.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
@AllArgsConstructor
public class MaterielEtatMaterielController {
    private final MaterielEtatMaterielDao materielEtatMaterielDao;
    @GetMapping("/materieletatmateriels/{idmat}/{idetat}")
    public Optional<MaterielEtatMateriel> getMaterielEtatMateriels(@PathVariable Integer idmat, @PathVariable Integer idetat) {

        return materielEtatMaterielDao.findByIdetatAndIdmat(idetat,idmat);

    }


}
