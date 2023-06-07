package org.sid.Ecommerce.Dto;


import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.Adresse;
import org.sid.Ecommerce.Entity.Category;

@Data
@Builder
public class AdresseDto {
    private Integer id;
    private String adresse1;
    private String adresse2;
    private String ville;
    private String codePostal;
    private String pays;
    // Faire Le Mapping Entre Category -> CategoryDto
    public static AdresseDto fromEntity(Adresse adresse) {
        if (adresse == null) {
            //  TODO  throw an exception
            return  null;
        }
        return  AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .ville(adresse.getVille())
                .codePostal(adresse.getCodePostal())
                .pays(adresse.getPays())
                .build();
    }

    // Faire Le Mapping Entre  CategoryDto -> Category

    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            //  TODO  throw an exception
            return  null;
        }

        Adresse adresse=new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setPays(adresseDto.getPays());
        adresse.setCodePostal(adresseDto.getCodePostal());
        adresse.setVille(adresseDto.getVille());
        return adresse;
    }
}
