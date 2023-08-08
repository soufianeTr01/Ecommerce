package org.sid.Ecommerce.Entity;

import javax.persistence.*;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
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
