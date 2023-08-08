package org.sid.Ecommerce.Entity;

import javax.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@Table(name = "LigneCommandFournisseur")
public class LigneCommandFournisseur extends Abstrat_Classes {
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    private BigDecimal quantite;

    private BigDecimal prixUnitaire;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    @ManyToOne
    @JoinColumn(name = "idcmdfournisseur")
    private  CommandFornisseur commandFornisseur;
}
