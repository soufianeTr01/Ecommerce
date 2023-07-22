package org.sid.Ecommerce.Controller;

import org.sid.Ecommerce.Controller.Api.VentesApi;
import org.sid.Ecommerce.Dto.VenteDto;
import org.sid.Ecommerce.Services.VentesService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentesController implements VentesApi {
    private VentesService ventesService;

    public VentesController(VentesService ventesService) {
        this.ventesService = ventesService;
    }

    @Override
    public VenteDto save(VenteDto dto) {
        return ventesService.save(dto);
    }

    @Override
    public VenteDto findById(Integer id) {
        return ventesService.findById(id);
    }

    public List<VenteDto> findAll() {
        return ventesService.findAll();
    }

    @Override
    public void delete(Integer id) {
        ventesService.delete(id);
    }
}
