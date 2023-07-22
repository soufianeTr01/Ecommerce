package org.sid.Ecommerce.Controller.Api;

import io.swagger.annotations.Api;
import org.sid.Ecommerce.Dto.EntrepriseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.sid.Ecommerce.Utils.Constant.APP_ROOT;

@Api("entreprises")
public interface EntrepriseApi {

  @PostMapping(APP_ROOT + "/entreprise/create")
  EntrepriseDto save(@RequestBody EntrepriseDto dto);

  @GetMapping(APP_ROOT + "/entreprise/{idEntreprise}")
  EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

  @GetMapping(APP_ROOT + "/entreprise/all")
  List<EntrepriseDto> findAll();

  @DeleteMapping(APP_ROOT + "/entreprise/delete/{idEntreprise}")
  void delete(@PathVariable("idEntreprise") Integer id);

}
