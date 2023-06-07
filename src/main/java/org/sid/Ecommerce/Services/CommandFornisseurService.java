package org.sid.Ecommerce.Services;

import org.sid.Ecommerce.Dto.CommandClientDto;
import org.sid.Ecommerce.Dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandFornisseurService {
    CommandeFournisseurDto save(CommandeFournisseurDto dto);
    CommandeFournisseurDto findById(Integer id);

    CommandeFournisseurDto findByCode(String code);

    List<CommandeFournisseurDto> findAll();

    void delete(Integer id);
}
