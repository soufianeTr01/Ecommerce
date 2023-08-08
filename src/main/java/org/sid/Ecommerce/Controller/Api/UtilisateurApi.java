package org.sid.Ecommerce.Controller.Api;


import io.swagger.annotations.Api;
import org.sid.Ecommerce.Dto.UtilisateurDto;
import org.sid.Ecommerce.Dto.VenteDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.sid.Ecommerce.Utils.Constant.APP_ROOT;

@Api("utilisateur")
public interface UtilisateurApi {

    @PostMapping(APP_ROOT + "/utilisateur/create")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @GetMapping(APP_ROOT + "/utilisateur/{idUtil}")
    UtilisateurDto findById(@PathVariable("idUtil") Integer id);
    @GetMapping(APP_ROOT + "/utilisateur/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(APP_ROOT + "/utilisateur/delete/{idUtil}")
    void delete(@PathVariable("idUtil") Integer id);

}
