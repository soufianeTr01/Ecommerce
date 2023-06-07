package org.sid.Ecommerce.Dao;

import org.sid.Ecommerce.Entity.CommandFornisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandFornisseur,Integer> {
    List<CommandFornisseur> findAllByFournisseurId(Integer id);
    Optional<CommandFornisseur> findCommandeFornisseurByCode(String code);

}
