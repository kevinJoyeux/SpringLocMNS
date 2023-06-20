package LOCMNS.demo.model.Materiel;


import javax.persistence.*;

import LOCMNS.demo.model.TableAssociative.MaterielEtatMateriel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class EtatMateriel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String etatMateriel;
    @OneToMany(mappedBy = "etatmateriel",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MaterielEtatMateriel> materiels;



}
