package org.sid.Ecommerce.Dto;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.Client;
import org.sid.Ecommerce.Entity.CommandClient;
import org.sid.Ecommerce.Entity.LigneCommandClient;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandClientDto {
    private Integer id;

    private String code;
    private Instant dateCommand;

    private ClientDto clientDto;
    private List<LigneCommandClientDto> ligneCommandClients;
    private Integer idEntreprise;


    // Faire Le Mapping Entre Category -> CategoryDto
    public static CommandClientDto fromEntity(CommandClient cmdClient) {
        if (cmdClient == null) {
            //  TODO  throw an exception
            return  null;
        }
        return  CommandClientDto.builder()
                .id(cmdClient.getId())
                .code(cmdClient.getCode())
                .dateCommand(cmdClient.getDateCommand())
                .clientDto(ClientDto.fromEntity(cmdClient.getClient()))
                .idEntreprise(cmdClient.getIdEntreprise())
                .build();
    }

    // Faire Le Mapping Entre  CategoryDto -> Category

    public static CommandClient toEntity(CommandClientDto cmdClientDto) {
        if (cmdClientDto == null) {
            //  TODO  throw an exception
            return  null;
        }

        CommandClient commandClient=new CommandClient();
        commandClient.setId(cmdClientDto.getId());
        commandClient.setCode(cmdClientDto.getCode());
        commandClient.setDateCommand(cmdClientDto.getDateCommand());
        commandClient.setClient(ClientDto.toEntity(cmdClientDto.getClientDto()));
        commandClient.setIdEntreprise(cmdClientDto.getIdEntreprise());

        return commandClient;
    }

}
