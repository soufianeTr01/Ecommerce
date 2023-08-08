package org.sid.Ecommerce.Dto;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.Article;
import org.sid.Ecommerce.Entity.MvtStk;
import org.sid.Ecommerce.Entity.SourceMvtStk;
import org.sid.Ecommerce.Entity.TypeMvtStk;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {
    private Integer id;

    private Instant dateMvt;
    private BigDecimal quantite;

    private ArticleDto article;
    private TypeMvtStk typeMvt;
    private SourceMvtStk sourceMvt;
    private Integer idEntreprise;


    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvtStk())
                .sourceMvt(mvtStk.getSourceMvtStk())
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto dto) {
        if (dto == null) {
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvtStk(dto.getTypeMvt());
        mvtStk.setSourceMvtStk(dto.getSourceMvt());
        mvtStk.setIdEntreprise(dto.getIdEntreprise());
        return mvtStk;
    }

}
