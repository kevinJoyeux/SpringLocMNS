package LOCMNS.demo.model.Materiel;


import javax.persistence.*;

import LOCMNS.demo.model.TableAssociative.LocationMateriel;
import LOCMNS.demo.model.TableAssociative.MaterielEtatMateriel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Materiel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matricule;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Modele modele;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private LieuStockage lieuStockage;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categorie categorie;
    @ManyToMany
    @JoinTable(name = "Materiel_documentation",joinColumns = @JoinColumn(name = "materiel_id"),inverseJoinColumns = @JoinColumn(name = "documentation_id"))
    private List<Documentation> materielDocumentations = new ArrayList<>();

    @OneToMany(mappedBy = "materiel",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LocationMateriel> locationMateriels;

    @OneToMany(mappedBy = "materiels",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MaterielEtatMateriel> MaterielEtat;





}
