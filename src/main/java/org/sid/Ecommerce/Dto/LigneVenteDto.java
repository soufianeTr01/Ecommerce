package org.sid.Ecommerce.Dto;

import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.LigneVentes;
import org.sid.Ecommerce.Entity.Ventes;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {
    private Integer id;
    private ArticleDto article;
    private VenteDto venteDto;

    private BigDecimal quantiter;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;

    public static LigneVenteDto fromEntity(LigneVentes ligneVente) {
        if (ligneVente == null) {
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .venteDto(VenteDto.fromEntity(ligneVente.getVente()))
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .quantiter(ligneVente.getQuantiter())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .idEntreprise(ligneVente.getIdEntreprise())

                .build();
    }

    public static LigneVentes toEntity(LigneVenteDto dto) {
        if (dto == null) {
            return null;
        }
        LigneVentes ligneVente = new LigneVentes();
        ligneVente.setId(dto.getId());
        ligneVente.setVente(VenteDto.toEntity(dto.getVenteDto()));
        ligneVente.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneVente.setQuantiter(dto.getQuantiter());
        ligneVente.setPrixUnitaire(dto.getPrixUnitaire());
        ligneVente.setIdEntreprise(dto.getIdEntreprise());

        return ligneVente;
    }


}
