package org.sid.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "MvtStk")
@Builder
public class MvtStk extends Abstrat_Classes {
    private Instant dateMvt;
    private BigDecimal quantite;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    private TypeMvtStk typeMvtStk;
    private SourceMvtStk sourceMvtStk;


}
