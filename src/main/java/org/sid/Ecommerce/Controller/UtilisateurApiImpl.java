package org.sid.Ecommerce.Controller;

import org.sid.Ecommerce.Controller.Api.UtilisateurApi;
import org.sid.Ecommerce.Dto.UtilisateurDto;
import org.sid.Ecommerce.Dto.VenteDto;
import org.sid.Ecommerce.Services.UtilisateurService;

import java.util.List;

public class UtilisateurApiImpl implements UtilisateurApi {

    private UtilisateurService utilisateurService;

    public UtilisateurApiImpl(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
