package org.sid.Ecommerce.Entity;




import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "Client")
@Builder
public class Client extends Abstrat_Classes {
    private String nom;
    private String prenom;
    private Adresse adresse;
    private String mail;
    private String numTel;
    @OneToMany(mappedBy = "client")
    private List<CommandClient> commandClients;
    @Column(name = "identreprise")
    private Integer idEntreprise;
}
