package LOCMNS.demo.model.Materiel;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class LieuStockage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String LieuStockage;

    @OneToMany(mappedBy = "lieuStockage",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Materiel> materiels;
}
