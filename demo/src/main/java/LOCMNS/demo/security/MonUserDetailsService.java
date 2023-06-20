package LOCMNS.demo.security;


import LOCMNS.demo.dao.Utilisateur.UtilisateurDao;
import LOCMNS.demo.model.Utilisateur.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        List<Utilisateur> optional = utilisateurDao.findByEmail(email);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException("L'utilisateur n'existe pas");
        }
        return new MonUserDetails(optional.get(0));
    }
    @Autowired
    private UtilisateurDao utilisateurDao;
}
