package org.sid.Ecommerce.Controller.Api;


import io.swagger.annotations.Api;
import org.sid.Ecommerce.Dto.CommandeFournisseurDto;
import org.sid.Ecommerce.Dto.FournisseurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.sid.Ecommerce.Utils.Constant.APP_ROOT;

@Api("fournisseur")
public interface FournisseurApi {



  @PostMapping(APP_ROOT + "/Fournisseur/create")
  FournisseurDto save(@RequestBody FournisseurDto dto);

  @GetMapping(APP_ROOT + "/Fournisseur/{idFournisseur}")
  FournisseurDto findById(@PathVariable Integer idFournisseur);


  @GetMapping(APP_ROOT + "Fournisseur/all")
  List<FournisseurDto> findAll();

  @DeleteMapping(APP_ROOT + "/Fournisseur/delete/{idFournisseur}")
  void delete(@PathVariable("Fournisseur") Integer id);


}
