package LOCMNS.demo.model.Utilisateur;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String login;
    private String sexe;
    private String affiliation;
    private String portable;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Statut statut;
}
