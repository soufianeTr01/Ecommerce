package org.sid.Ecommerce.Controller.Api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.sid.Ecommerce.Dto.ArticleDto;
import org.sid.Ecommerce.Dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.sid.Ecommerce.Utils.Constant.APP_ROOT;

@Api(APP_ROOT+"/category")

public interface CategoryApi {
    @PostMapping(value = APP_ROOT + "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un category (Ajouter/Modifier)",notes = "cette methode permet de enregistrer ou modifier un  category",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Lobjet category creer ou  modifier"),
            @ApiResponse(code = 400, message = "L'objet category n'est pas valide")

    })
    CategoryDto save(@RequestBody CategoryDto categoryDto);
    @GetMapping(value = APP_ROOT+"/category/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un category", notes = "Cette methode permet de chercher un category par son Id", response =CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "category a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun category n'existe dans la BDD avec le CODE fourni")
    })
    CategoryDto findById(@PathVariable(name = "idCategory")Integer id);
    @GetMapping(value = APP_ROOT+"/category/{codeCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un category", notes = "Cette methode permet de chercher un category par son Code", response =CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "category a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun category n'existe dans la BDD avec le CODE fourni")
    })
    CategoryDto findByCode(@PathVariable(name = "codeCategory")String code);
    @GetMapping(value = APP_ROOT+"/category/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher tous les category", notes = "Cette methode permet de chercher les category", responseContainer ="List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Les  category a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun category n'existe dans la BDD ")
    })
    List<CategoryDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/category/delete/{idCategory}")
    @ApiOperation(value = "Supprimer une category", notes = "Cette methode permet de supprimer un category par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "category a ete supprimer")
    })
    void delete(@PathVariable (name = "idCategory") Integer id);
}
