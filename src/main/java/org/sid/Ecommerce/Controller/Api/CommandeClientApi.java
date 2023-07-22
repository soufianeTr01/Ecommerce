package org.sid.Ecommerce.Controller.Api;


import io.swagger.annotations.Api;
import org.sid.Ecommerce.Dto.CommandClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.sid.Ecommerce.Utils.Constant.APP_ROOT;

@Api("commandesclients")
public interface CommandeClientApi {


  @PostMapping(APP_ROOT + "/commandesclients/create")
  CommandClientDto save(@RequestBody CommandClientDto dto);

  @GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")
  CommandClientDto findById(@PathVariable Integer idCommandeClient);

  @GetMapping(APP_ROOT + "/commandesclients/{codeCommandeClient}")
  CommandClientDto findByCode(@PathVariable("codeCommandeClient") String code);

  @GetMapping(APP_ROOT + "/commandesclients/all")
  List<CommandClientDto> findAll();

  @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
  void delete(@PathVariable("idCommandeClient") Integer id);

}
