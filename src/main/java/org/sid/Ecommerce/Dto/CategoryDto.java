package org.sid.Ecommerce.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.Category;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private Integer id;

    private  String code;
    private String designation;
    @JsonIgnore
    private List<ArticleDto> articleList;
    private Integer idEntreprise;


    // Faire Le Mapping Entre Category -> CategoryDto
    public  static  CategoryDto fromEntity(Category category) {
        if (category == null) {
            //  TODO  throw an exception
            return  null;
        }
        return  CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .idEntreprise(category.getIdEntreprise())
                .build();
    }

    // Faire Le Mapping Entre  CategoryDto -> Category

    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            //  TODO  throw an exception
            return  null;
        }

                Category category=new Category();
                category.setId(categoryDto.getId());
                category.setCode(categoryDto.getCode());
                category.setDesignation(categoryDto.getDesignation());
                category.setIdEntreprise(categoryDto.getIdEntreprise());
        return category;
    }
}
