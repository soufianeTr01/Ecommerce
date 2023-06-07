package org.sid.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "CommandClient")
@Builder
public class CommandClient extends Abstrat_Classes {
    private String code;
    private Instant dateCommand;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
   @OneToMany(mappedBy = "commandClient")
    private List<LigneCommandClient> ligneCommandClients;
    @Column(name = "identreprise")
    private Integer idEntreprise;
}
