package LOCMNS.demo.model.Location;

import LOCMNS.demo.model.TableAssociative.LocationMateriel;

import javax.persistence.*;

import LOCMNS.demo.model.Utilisateur.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String raisonLocation;
    private Boolean decision;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateDemandeLocation;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateFinLocationPrevue;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateDebutLocationPrevue;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateProlongation;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateValidationProlongation;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateLocationEtat;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateDecision;

    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<LocationMateriel> locations;


}
