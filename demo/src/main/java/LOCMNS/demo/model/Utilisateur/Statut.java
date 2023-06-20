package LOCMNS.demo.model.Utilisateur;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Statut {
    @Id
    private Integer id;

    private String nomStatut;

    @OneToMany(mappedBy = "statut",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Utilisateur> utilisateurs;
}
