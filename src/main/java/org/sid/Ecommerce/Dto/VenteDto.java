package org.sid.Ecommerce.Dto;

import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.Ventes;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class VenteDto {
    private Integer id;

    private String  code;
    private Instant dateVente;
    private String  commentaire;
    private List<LigneVenteDto> ligneVentes;
    private Integer idEntreprise;


    public static VenteDto fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    public static Ventes toEntity(VenteDto dto) {
        if (dto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(dto.getId());
        ventes.setCode(ventes.getCode());
        ventes.setCommentaire(dto.getCommentaire());
        ventes.setIdEntreprise(dto.getIdEntreprise());

        return ventes;
    }
}
