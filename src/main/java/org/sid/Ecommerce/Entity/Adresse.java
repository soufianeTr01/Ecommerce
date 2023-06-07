package org.sid.Ecommerce.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class Adresse{
    private String adresse1;
    private String adresse2;
    private String ville;
    private String codePostal;
    private String pays;
}
