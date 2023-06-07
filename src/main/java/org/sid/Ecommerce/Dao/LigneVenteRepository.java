package org.sid.Ecommerce.Dao;

import org.sid.Ecommerce.Entity.LigneVentes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneVenteRepository extends JpaRepository<LigneVentes, Integer> {

}
