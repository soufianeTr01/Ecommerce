package org.sid.Ecommerce.Controller;

import org.sid.Ecommerce.Controller.Api.CommandeClientApi;
import org.sid.Ecommerce.Dto.CommandClientDto;
import org.sid.Ecommerce.Services.CommandClientService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeClientController implements CommandeClientApi {
  private   CommandClientService commandClientService;

    public CommandeClientController(CommandClientService commandClientService) {
        this.commandClientService = commandClientService;
    }

    @Override
    public CommandClientDto save(CommandClientDto dto) {
        return commandClientService.save(dto);
    }

    @Override
    public CommandClientDto findById(Integer idCommandeClient) {
        return commandClientService.findById(idCommandeClient);
    }

    @Override
    public  CommandClientDto findByCode(String code) {
        return commandClientService.findByCode(code);
    }

    @Override
    public  List<CommandClientDto> findAll() {
        return commandClientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        commandClientService.delete(id);
    }
}
