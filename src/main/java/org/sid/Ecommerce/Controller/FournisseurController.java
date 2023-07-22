package org.sid.Ecommerce.Controller;

import org.sid.Ecommerce.Controller.Api.FournisseurApi;
import org.sid.Ecommerce.Dto.CommandeFournisseurDto;
import org.sid.Ecommerce.Dto.FournisseurDto;
import org.sid.Ecommerce.Services.FournisseurService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {
    private FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Integer idFournisseur) {
        return fournisseurService.findById(idFournisseur);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
