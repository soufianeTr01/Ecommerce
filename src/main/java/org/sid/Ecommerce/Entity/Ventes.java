package org.sid.Ecommerce.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
