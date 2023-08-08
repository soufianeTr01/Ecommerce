package org.sid.Ecommerce.Entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@Table(name = "Entreprise")
public class Entreprise extends Abstrat_Classes {
    private String  nom;
    private String description;
    private String codeFiscal;
    private Adresse adresse;
    private String photo;
    private String email;
    private String numTel;
    private String steWeb;
    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;
}
