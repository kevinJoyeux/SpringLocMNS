package LOCMNS.demo.model.Materiel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
@Embeddable
@Getter
@Setter
public class CleMaterielEtatMateriel implements Serializable {
    private Integer idmat;
    private Integer idetat;
    private Date dateEtatMateriel;
}
