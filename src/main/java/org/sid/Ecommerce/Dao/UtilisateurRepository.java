package org.sid.Ecommerce.Dao;

import org.sid.Ecommerce.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    // Optional : ca facilite Implementation des objet
   Optional <Utilisateur> findByEmail(String email);


}
