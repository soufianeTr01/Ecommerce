package org.sid.Ecommerce.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")

public class Article extends Abstrat_Classes {
    private String codeArticle;
    private String designation;
    private BigDecimal priceUniqueHt;
    private BigDecimal taxTva;
    private BigDecimal priceUniqueTva;
    private String photo;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private  Category category;

    @OneToMany(mappedBy = "article")
    private List<LigneVentes> ligneVentes;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandFournisseur> ligneCommandeFournisseurs;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    @OneToMany(mappedBy = "article")
    private List<MvtStk> mvtStks;

}
