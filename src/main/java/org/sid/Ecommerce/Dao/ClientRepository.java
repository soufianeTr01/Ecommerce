package org.sid.Ecommerce.Dao;

import org.sid.Ecommerce.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
