package org.sid.Ecommerce.Controller.Api;

import io.swagger.annotations.Api;
import org.sid.Ecommerce.Dto.VenteDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.sid.Ecommerce.Utils.Constant.APP_ROOT;


@Api("ventes")
public interface VentesApi {

  @PostMapping(APP_ROOT + "/ventes/create")
  VenteDto save(@RequestBody VenteDto dto);

  @GetMapping(APP_ROOT + "/ventes/{idVente}")
  VenteDto findById(@PathVariable("idVente") Integer id);
  @GetMapping(APP_ROOT + "/ventes/all")
  List<VenteDto> findAll();

  @DeleteMapping(APP_ROOT + "/ventes/delete/{idVente}")
  void delete(@PathVariable("idVente") Integer id);

}
