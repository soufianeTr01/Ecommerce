package org.sid.Ecommerce.Controller;

import org.sid.Ecommerce.Controller.Api.CommandFourniseurAPi;
import org.sid.Ecommerce.Dto.CommandeFournisseurDto;
import org.sid.Ecommerce.Services.CommandFornisseurService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeFournisseurController implements CommandFourniseurAPi {
    private CommandFornisseurService commandFornisseurService;

    public CommandeFournisseurController(CommandFornisseurService commandFornisseurService) {
        this.commandFornisseurService = commandFornisseurService;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        return commandFornisseurService.save(dto);
    }

    @Override
    public CommandeFournisseurDto findById(Integer idCommandeFournisseur) {
        return commandFornisseurService.findById(idCommandeFournisseur);
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandFornisseurService.findByCode(code);
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandFornisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        commandFornisseurService.delete(id);
    }
}
