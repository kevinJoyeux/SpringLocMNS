package LOCMNS.demo.model.TableAssociative;

import LOCMNS.demo.model.Location.Location;
import LOCMNS.demo.model.Materiel.CleMaterielEtatMateriel;
import LOCMNS.demo.model.Materiel.EtatMateriel;
import LOCMNS.demo.model.Materiel.Materiel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "materiel_etat_materiel")
@IdClass(CleMaterielEtatMateriel.class)
@Getter
@Setter
public class MaterielEtatMateriel {
    @Id
    private Integer idmat;
    @Id
    private Integer idetat;
    @Id
    private Date dateEtatMateriel;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId
    @JoinColumn(name = "idmat")
    private Materiel materiels;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId
    @JoinColumn(name = "idetat")
    private EtatMateriel etatmateriel;

}
