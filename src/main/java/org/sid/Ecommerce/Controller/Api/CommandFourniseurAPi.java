package org.sid.Ecommerce.Controller.Api;

import io.swagger.annotations.Api;
import org.sid.Ecommerce.Dto.CommandeFournisseurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.sid.Ecommerce.Utils.Constant.APP_ROOT;

@Api("commandefournisseur")

public interface CommandFourniseurAPi {

    @PostMapping(APP_ROOT + "/commandesFournisseur/create")
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(APP_ROOT + "/commandeFournisseur/{idCommandeFournisseur}")
    CommandeFournisseurDto findById(@PathVariable Integer idCommandeFournisseur);

    @GetMapping(APP_ROOT + "/commandeFournisseur/{codeCommandeFournisseur}")
    CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

    @GetMapping(APP_ROOT + "/commandeFournisseur/all")
    List<CommandeFournisseurDto> findAll();

    @DeleteMapping(APP_ROOT + "/commandeFournisseur/delete/{idCommandeFournisseur}")
    void delete(@PathVariable("idCommandeFournisseur") Integer id);

}
