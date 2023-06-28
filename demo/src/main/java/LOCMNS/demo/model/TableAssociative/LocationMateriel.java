package LOCMNS.demo.model.TableAssociative;

import LOCMNS.demo.model.Location.Location;
import LOCMNS.demo.model.Materiel.CleLocationMateriel;
import LOCMNS.demo.model.Materiel.Materiel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "location_materiel")
@IdClass(CleLocationMateriel.class)
@Getter
@Setter
public class LocationMateriel {
    @Id
    private Integer materiel_id;
    @Id
    private Integer location_id;
    private String retour;
    private LocalDate DateRetourMateriel;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId
    @JoinColumn(name = "materiel_id")
    private Materiel materiel;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId
    @JoinColumn(name = "location_id")
    private Location location;
    @Embeddable
    @Getter
    @Setter
    public class CleLocationMateriel implements Serializable {
        private Integer materiel_id;
        private Integer location_id;


    }

}
