package LOCMNS.demo.controller.Utilisateur;

import LOCMNS.demo.dao.Utilisateur.UtilisateurDao;
import LOCMNS.demo.model.Utilisateur.Utilisateur;
import LOCMNS.demo.security.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UtilisateurController {

    private final UtilisateurDao utilisateurDao;
    private JwtUtils jwtUtils;

    private BCryptPasswordEncoder passwordEncoder;
    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUtilisateurs() {

        return utilisateurDao.findAll();

    }
    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable int id){
        Optional<Utilisateur> existe = utilisateurDao.findById(id);
        if (existe.isPresent()){
            return new ResponseEntity<>(existe.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/utilisateur")
    public ResponseEntity<Utilisateur> ajoutUtilisateur(@RequestBody Utilisateur nouvelUtilisateur){
        if(nouvelUtilisateur.getMotDePasse() != null) {
            if (nouvelUtilisateur.getMotDePasse().length() != 60) {
                String mdp = nouvelUtilisateur.getMotDePasse();
                nouvelUtilisateur.setMotDePasse(passwordEncoder.encode(mdp));
            }
        }
        if(nouvelUtilisateur.getId()!=null){ //l'utilisateur possède un id

            Optional<Utilisateur> optional = utilisateurDao.findById(nouvelUtilisateur.getId());
            if(optional.isPresent()){
                this.utilisateurDao.save(nouvelUtilisateur);
                return new ResponseEntity<>(nouvelUtilisateur,HttpStatus.OK);
            }
            return new ResponseEntity<>(nouvelUtilisateur,HttpStatus.BAD_REQUEST);
        }else{
            this.utilisateurDao.save(nouvelUtilisateur);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> supprimeUtilisateur(@PathVariable int id) {
        Optional<Utilisateur> utilisateurAsupprimer = utilisateurDao.findById(id);
        if (utilisateurAsupprimer.isPresent()) {
            utilisateurDao.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/user/utilisateur")
    public ResponseEntity<Utilisateur> getInformationUtilisateurConnecte(
            @RequestHeader(value="Authorization") String authorization){
        String token = authorization.substring(7);
        String email = jwtUtils.getData(token).getSubject();
        System.out.println(email);
        List<Utilisateur> utilisateur = utilisateurDao.findByEmail(email);
        if(utilisateur.get(0)!=null) {
            return ResponseEntity.ok().body(utilisateur.get(0));
        }

        return ResponseEntity.notFound().build();
    }

    // tri selon paramètres
    @GetMapping("/utilisateurPrenom")
    public List<Utilisateur> getUtilisateursOrderByPrenom() {
        return utilisateurDao.OrderByPrenom();
    }
    @GetMapping("/utilisateurNom")
    public List<Utilisateur> getUtilisateursOrderByNom() {
        return utilisateurDao.OrderByNom();
    }
    @GetMapping("/utilisateurStatut")
    public List<Utilisateur> getUtilisateursOrderByStatut() {
        return utilisateurDao.OrderByNomStatut();
    }
    @GetMapping("/utilisateurSexe")
    public List<Utilisateur> getUtilisateursOrderBySexe() {
        return utilisateurDao.OrderBySexe();
    }

    // Recherche
    @GetMapping("/utilisateurRecherche/{recherche}")
    public List<Utilisateur> getUtilisateursRecherche(@PathVariable String recherche) {
        if(recherche !=""){
            return utilisateurDao.ChercherUtilisateur(recherche);
        }else{
            return utilisateurDao.findAll();
        }
    }
    @GetMapping("/utilisateur/{prenom}/{nom}")
    public List<Utilisateur> getUtilisateursPrenomNomRecherche(@PathVariable String prenom, @PathVariable String nom){
        return utilisateurDao.findByPrenomAndNom(prenom,nom);
    }
    @GetMapping("/utilisateuremail/{email}")
    public List<Utilisateur> getUtilisateurByEmail(@PathVariable String email){
        return utilisateurDao.findByEmail(email);
    }
}
