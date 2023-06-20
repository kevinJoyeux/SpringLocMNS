package LOCMNS.demo.model.Materiel;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Getter
@Setter
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Marque marque;

    @OneToMany(mappedBy = "modele",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Materiel> materiels;
}
