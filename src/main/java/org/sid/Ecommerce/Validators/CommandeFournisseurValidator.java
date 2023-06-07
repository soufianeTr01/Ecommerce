package org.sid.Ecommerce.Validators;

import org.sid.Ecommerce.Dto.CommandClientDto;
import org.sid.Ecommerce.Dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public static List<String> ValidateCommandFournisseur(CommandeFournisseurDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner le Fournisseur");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (dto.getDateCmd() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }

        if (dto.getFournisseur() == null || dto.getFournisseur().getId() == null) {
            errors.add("Veuillez renseigner le fournisseur");
        }

        return errors;
    }
}
