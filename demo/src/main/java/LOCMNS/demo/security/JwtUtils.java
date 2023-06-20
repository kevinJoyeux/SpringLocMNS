package LOCMNS.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {
    public static String generateJwt(MonUserDetails userDetails){
        Map<String, Object> donnees= new HashMap<>();
        donnees.put("utilisateur", userDetails.getUtilisateur());
        return Jwts.builder()
                .setClaims(donnees)
                .setSubject(userDetails.getUsername())
                .signWith(SignatureAlgorithm.HS256,"azerty")
                .compact();
    }
    public static Claims getData(String jwt){
        return Jwts.parser()
                .setSigningKey("azerty")
                .parseClaimsJws(jwt)
                .getBody();
    }
    public static boolean isTokenValide(String jwt){
        try{
            Claims donnes = getData(jwt);
        }catch (SignatureException e){
            return false;
        }
        return true;
    }
}
