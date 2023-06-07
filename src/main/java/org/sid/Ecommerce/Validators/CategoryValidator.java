package org.sid.Ecommerce.Validators;

import org.sid.Ecommerce.Dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> Validate(CategoryDto categoryDto){
        List<String> errors=new ArrayList<>();
        if(categoryDto==null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Veuillez renseigner le code de la categorie");
        }
        return errors;
    }
}
