package org.sid.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@Table(name = "Fournisseur")
public class Fournisseur extends Abstrat_Classes {
    private String nom;
    private String prenom;
    @Embedded
    private Adresse adresse;
    private String mail;
    private String photo;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    private String numTel;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandFornisseur> commandFornisseurs;
}
