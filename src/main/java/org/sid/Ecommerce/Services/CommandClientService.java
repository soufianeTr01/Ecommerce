package org.sid.Ecommerce.Services;

import org.sid.Ecommerce.Dto.CommandClientDto;

import java.util.List;

public interface CommandClientService {
    CommandClientDto save(CommandClientDto dto);
    CommandClientDto findById(Integer id);

    CommandClientDto findByCode(String code);

    List<CommandClientDto> findAll();

    void delete(Integer id);
}
