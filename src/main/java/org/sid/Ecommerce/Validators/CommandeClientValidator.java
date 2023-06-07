package org.sid.Ecommerce.Validators;

import org.sid.Ecommerce.Dto.CommandClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> ValidateCommandClient(CommandClientDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (dto.getDateCommand() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }

        if (dto.getClientDto() == null || dto.getClientDto().getId() == null) {
            errors.add("Veuillez renseigner le client");
        }

        return errors;
    }

}
