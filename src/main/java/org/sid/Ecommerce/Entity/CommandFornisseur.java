package org.sid.Ecommerce.Entity;


import javax.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@Table(name = "CommandFornisseur")
public class CommandFornisseur extends Abstrat_Classes {
    private String code;
    private Instant dateCmd;
    @ManyToOne
    @JoinColumn(name = "id_fourniseur")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commandFornisseur")
    private List<LigneCommandFournisseur> ligneCommandFournisseurs;
    @Column(name = "identreprise")
    private Integer idEntreprise;

}
