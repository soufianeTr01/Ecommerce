package org.sid.Ecommerce.Dto;

import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.LigneCommandFournisseur;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {
    private Integer id;

    private ArticleDto article;

    private CommandeFournisseurDto commandeFournisseurDto;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;


    public static LigneCommandeFournisseurDto fromEntity(LigneCommandFournisseur ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null) {
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .idEntreprise(ligneCommandeFournisseur.getIdEntreprise())
                .build();
    }

    public static LigneCommandFournisseur toEntity(LigneCommandeFournisseurDto dto) {
        if (dto == null) {
            return null;
        }

        LigneCommandFournisseur ligneCommandeFournisseur = new LigneCommandFournisseur();
        ligneCommandeFournisseur.setId(dto.getId());
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneCommandeFournisseur.setPrixUnitaire(dto.getPrixUnitaire());
        ligneCommandeFournisseur.setQuantite(dto.getQuantite());
        ligneCommandeFournisseur.setIdEntreprise(dto.getIdEntreprise());
        return ligneCommandeFournisseur;
    }
}
