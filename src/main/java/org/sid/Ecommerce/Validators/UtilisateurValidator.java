package org.sid.Ecommerce.Validators;

import org.sid.Ecommerce.Dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String > ValidateUtilisteur(UtilisateurDto utilisateurDto){

        List<String>errors=new ArrayList<>();
        if (utilisateurDto == null) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");

            errors.addAll(AdresseValidator.validateAdresse(null));
            return errors;
        }

        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillez renseigner le Nom de l'Utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner le Prenom de l'Utilisateur");
        }if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner l' email de l'Utilisateur");
        }
        if(utilisateurDto.getDateNaissance()==null){
            errors.add("Veuillez renseigner la date  de Naissance");
        }
        if(utilisateurDto.getAdresse()==null){
            errors.add("Veuillez renseigner l'Adresse  de l'Utilisateur");
        }
        else{
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                errors.add("l'adresse 1 est obligatoire ");
              }if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostal())){
                errors.add("le CodePostal  est obligatoire ");
              }if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("le Pays  est obligatoire ");
              }if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("la Ville  est obligatoire ");
              }

        }
        if(errors.addAll(AdresseValidator.validateAdresse(utilisateurDto.getAdresse())));


        return  errors;
    }
}
