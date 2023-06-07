package org.sid.Ecommerce.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "LigneVentes")
@Builder
public class LigneVentes extends Abstrat_Classes {
    @ManyToOne
    @JoinColumn(name = "idVente")
    private Ventes vente;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    private BigDecimal quantiter;
    private BigDecimal prixUnitaire;

}
