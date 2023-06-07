package org.sid.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@Table(name = "LigneCommandClient")
public class LigneCommandClient extends Abstrat_Classes {
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "idcommandClient")
    private CommandClient commandClient;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    @Column(name = "identreprise")
    private Integer idEntreprise;
}
