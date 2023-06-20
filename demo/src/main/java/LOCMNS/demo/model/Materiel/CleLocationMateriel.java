package LOCMNS.demo.model.Materiel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class CleLocationMateriel implements Serializable {
    private Integer materiel_id;
    private Integer location_id;


}
