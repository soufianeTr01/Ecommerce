package org.sid.Ecommerce.Dao;

import org.sid.Ecommerce.Dto.CommandClientDto;
import org.sid.Ecommerce.Entity.CommandClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;


public interface CommandeClientRepository extends JpaRepository<CommandClient, Integer> {


    Optional<CommandClient> findCommandeClientByCode(String code);

    List<CommandClient> findAllByClientId(Integer id);

}
