package org.sid.Ecommerce.Dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.CommandClient;
import org.sid.Ecommerce.Entity.CommandFornisseur;
import org.sid.Ecommerce.Entity.Fournisseur;
import org.sid.Ecommerce.Entity.LigneCommandFournisseur;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class CommandeFournisseurDto {
    private Integer id;

    private String code;
    private Instant dateCmd;
    private FournisseurDto fournisseur;
    private List<LigneCommandeFournisseurDto> ligneCommandFournisseurs;
    private Integer idEntreprise;
    // Faire Le Mapping Entre Category -> CategoryDto
    public  static CommandeFournisseurDto fromEntity(CommandFornisseur commandFornisseur) {
        if (commandFornisseur == null) {
            //  TODO  throw an exception
            return  null;
        }
        return  CommandeFournisseurDto.builder()
                .id(commandFornisseur.getId())
                .code(commandFornisseur.getCode())
                .dateCmd(commandFornisseur.getDateCmd())
                .fournisseur(FournisseurDto.fromEntity(commandFornisseur.getFournisseur()))
                .idEntreprise(commandFornisseur.getIdEntreprise())

                .build();
    }

    // Faire Le Mapping Entre  CategoryDto -> Category

    public static CommandFornisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if (commandeFournisseurDto == null) {
            //  TODO  throw an exception
            return  null;
        }

        CommandFornisseur commandeFournisseur=new CommandFornisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCmd(commandeFournisseurDto.getDateCmd());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));
        commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());

        return commandeFournisseur;
    }

}
