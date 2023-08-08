package org.sid.Ecommerce.Entity;

import javax.persistence.*;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "Ventes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ventes extends Abstrat_Classes {
    private String  code;
    private Instant dateVente;
    private String  commentaire;
    @OneToMany(mappedBy = "vente")
    List<LigneVentes> ligneVentes;
    @Column(name = "identreprise")
    private Integer idEntreprise;
}
