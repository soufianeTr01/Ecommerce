package org.sid.Ecommerce.Dao;

import org.sid.Ecommerce.Dto.VenteDto;
import org.sid.Ecommerce.Entity.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface VentesRepository extends JpaRepository<Ventes, Integer> {
    Optional<Ventes> findByCode(String code);

}
