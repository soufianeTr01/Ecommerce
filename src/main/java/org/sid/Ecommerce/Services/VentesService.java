package org.sid.Ecommerce.Services;

import org.sid.Ecommerce.Dto.VenteDto;

import java.util.List;

public interface VentesService {

    VenteDto save(VenteDto dto);

    VenteDto findById(Integer id);

    VenteDto findByCode(String code);

    List<VenteDto> findAll();

    void delete(Integer id);
}
