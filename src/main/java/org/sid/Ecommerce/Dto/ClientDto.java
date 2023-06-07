package org.sid.Ecommerce.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.*;

import java.util.List;

@Data
@Builder
public class ClientDto {
    private Integer id;

    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String mail;
    private String numTel;
    private Integer idEntreprise;

    @JsonIgnore
    private List<CommandClientDto> commandClients;


    // Faire Le Mapping Entre Category -> CategoryDto
    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            //  TODO  throw an exception
            return  null;
        }
        return  ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .idEntreprise(client.getIdEntreprise())
                .build();
    }

    // Faire Le Mapping Entre  CategoryDto -> Category

    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            //  TODO  throw an exception
            return  null;
        }

        Client client=new Client();

        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
        client.setMail(clientDto.getMail());
        client.setNumTel(clientDto.getNumTel());
        client.setIdEntreprise(clientDto.getIdEntreprise());

        return client;
    }
}
