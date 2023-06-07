package org.sid.Ecommerce.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.Article;
import org.sid.Ecommerce.Entity.CommandClient;
import org.sid.Ecommerce.Entity.LigneCommandClient;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandClientDto {
    private Integer id;

    private ArticleDto article;
    @JsonIgnore
    private CommandClientDto commandClientDto;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;

    public static LigneCommandClientDto fromEntity(LigneCommandClient ligneCommandeClient) {
        if (ligneCommandeClient == null) {
            return null;
        }
        return LigneCommandClientDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .idEntreprise(ligneCommandeClient.getIdEntreprise())
                .build();
    }
    public static LigneCommandClient toEntity(LigneCommandClientDto dto) {
        if (dto == null) {
            return null;
        }

        LigneCommandClient ligneCommandeClient = new LigneCommandClient();
        ligneCommandeClient.setId(dto.getId());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneCommandeClient.setPrixUnitaire(dto.getPrixUnitaire());
        ligneCommandeClient.setQuantite(dto.getQuantite());
        ligneCommandeClient.setIdEntreprise(dto.getIdEntreprise());
        return ligneCommandeClient;
    }
}
