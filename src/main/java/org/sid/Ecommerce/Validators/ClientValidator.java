package org.sid.Ecommerce.Validators;

import org.sid.Ecommerce.Dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> ValidateClient(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();

        if (clientDto == null) {
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner le prenom du client");
            errors.add("Veuillez renseigner le Mail du client");
            errors.add("Veuillez renseigner le numero de telephone du client");
            errors.addAll(AdresseValidator.validateAdresse(null));
            return errors;
        }

        if (!StringUtils.hasLength(clientDto.getNom())) {
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom du client");
        }
        if (!StringUtils.hasLength(clientDto.getMail())) {
            errors.add("Veuillez renseigner le Mail du client");
        }
        if (!StringUtils.hasLength(clientDto.getNumTel())) {
            errors.add("Veuillez renseigner le numero de telephone du client");
        }
        if(errors.addAll(AdresseValidator.validateAdresse(clientDto.getAdresse())));

            return errors;
    }

}