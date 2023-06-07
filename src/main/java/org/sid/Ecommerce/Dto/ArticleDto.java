package org.sid.Ecommerce.Dto;

import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.Article;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {
    private Integer id;

    private String codeArticle;
    private String designation;
    private BigDecimal priceUniqueHt;
    private BigDecimal taxTva;
    private BigDecimal priceUniqueTva;
    private String photo;
    private CategoryDto category;
    private Integer idEntreprise;


    // Faire Le Mapping Entre Category -> CategoryDto
    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            //  TODO  throw an exception
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .priceUniqueHt(article.getPriceUniqueHt())
                .priceUniqueTva(article.getPriceUniqueTva())
                .taxTva(article.getTaxTva())
                .photo(article.getPhoto())
                .idEntreprise(article.getIdEntreprise())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    // Faire Le Mapping Entre  CategoryDto -> Category

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            //  TODO  throw an exception
            return null;
        }

        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPriceUniqueHt(articleDto.getPriceUniqueHt());
        article.setPriceUniqueTva(articleDto.getPriceUniqueTva());
        article.setTaxTva(articleDto.getTaxTva());
        article.setPhoto(articleDto.getPhoto());
        article.setIdEntreprise(articleDto.getIdEntreprise());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));


        return article;
    }
}
