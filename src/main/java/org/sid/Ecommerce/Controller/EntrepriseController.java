package org.sid.Ecommerce.Controller;

import org.sid.Ecommerce.Controller.Api.EntrepriseApi;
import org.sid.Ecommerce.Dto.EntrepriseDto;
import org.sid.Ecommerce.Services.EntrepriseService;

import java.util.List;

public class EntrepriseController implements EntrepriseApi {
    private EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
entrepriseService.delete(id);
    }
}
