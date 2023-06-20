package LOCMNS.demo.controller;

import LOCMNS.demo.dao.Utilisateur.UtilisateurDao;
import LOCMNS.demo.model.Utilisateur.Utilisateur;
import LOCMNS.demo.security.JwtUtils;
import LOCMNS.demo.security.MonUserDetails;
import LOCMNS.demo.security.MonUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
@RestController
@CrossOrigin
@AllArgsConstructor
public class ConnexionController {

    AuthenticationManager authenticationManager;

    UtilisateurDao utilisateurDao;

    PasswordEncoder passwordEncoder;

    JwtUtils jwtUtils;
    
    MonUserDetailsService userDetailsService;
    @PostMapping("/connexion")
    public ResponseEntity<String> connexion(@RequestBody Utilisateur utilisateur){
        MonUserDetails userDetails ;
        try {
            userDetails = (MonUserDetails) authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            utilisateur.getEmail(),
                            utilisateur.getMotDePasse()
                    )
            ).getPrincipal();
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        MonUserDetails monUserDetails =(MonUserDetails) userDetailsService.loadUserByUsername(utilisateur.getEmail());
        return new ResponseEntity<>(JwtUtils.generateJwt(monUserDetails),HttpStatus.OK);
    }
    @PostMapping("/inscription")
    public ResponseEntity<Utilisateur> inscription (@RequestBody Utilisateur utilisateur){
        if(utilisateur.getId()!=null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(utilisateur.getMotDePasse().length()<=3){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(utilisateur.getEmail()).matches()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Utilisateur> optionnal = utilisateurDao.findByEmail(utilisateur.getEmail());
        if(optionnal.get(0)!=null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String passwordHache = passwordEncoder.encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(passwordHache);

        utilisateurDao.save(utilisateur);

        return new ResponseEntity<>(utilisateur,HttpStatus.CREATED);
    }
    @GetMapping("/deconnexion")
    public ResponseEntity <String> deconnexion (@RequestHeader("Authorization" ) String jwt){
        String token = jwt.substring( 7);
        int idUtilisateurConnecte = (int) jwtUtils.getData(token).get("id");
        Optional<Utilisateur > utilisateurOptional = utilisateurDao.findById(idUtilisateurConnecte);
        if(utilisateurOptional .isPresent()) {
            utilisateurDao.save(utilisateurOptional.get());
            return ResponseEntity .ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}

