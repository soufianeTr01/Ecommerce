package org.sid.Ecommerce.Dao;

import org.sid.Ecommerce.Entity.CommandClient;
import org.sid.Ecommerce.Entity.CommandFornisseur;
import org.sid.Ecommerce.Entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}
