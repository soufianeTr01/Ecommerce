package org.sid.Ecommerce.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "Category")
@Builder
public class Category extends Abstrat_Classes {
    private  String code;
    private String designation;
    /*@OneToMany(mappedBy = "category")
    private List<Article> articleList;*/
    @Column(name = "identreprise")
    private Integer idEntreprise;
}
