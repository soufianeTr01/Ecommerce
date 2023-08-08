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
@Table(name = "Utilisateur")
public class Utilisateur extends Abstrat_Classes {
    private String nom;
    private String prenom;
    private String email;

    private Instant dateNaissance;
    private String motDePasse;

    private Adresse adresse;
    private String photo;
    @ManyToOne
    @JoinColumn(name = "identreprise")
    private  Entreprise entreprise;
    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> roles;
}
