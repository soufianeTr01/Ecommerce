package org.sid.Ecommerce.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.Adresse;
import org.sid.Ecommerce.Entity.Entreprise;
import org.sid.Ecommerce.Entity.Utilisateur;

import java.util.List;

@Data
@Builder
public class EntrepriseDto {
    private Integer id;

    private String  nom;
    private String description;
    private String codeFiscal;
    private AdresseDto adresse;
    private String photo;
    private String email;
    private String numTel;
    private String steWeb;

    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;


    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .steWeb(entreprise.getSteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto dto) {
        if (dto == null) {
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(dto.getId());
        entreprise.setNom(dto.getNom());
        entreprise.setDescription(dto.getDescription());
        entreprise.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        entreprise.setCodeFiscal(dto.getCodeFiscal());
        entreprise.setPhoto(dto.getPhoto());
        entreprise.setEmail(dto.getEmail());
        entreprise.setNumTel(dto.getNumTel());
        entreprise.setSteWeb(dto.getSteWeb());

        return entreprise;
    }
}
