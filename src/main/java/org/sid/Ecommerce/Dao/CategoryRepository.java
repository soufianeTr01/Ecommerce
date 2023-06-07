package org.sid.Ecommerce.Dao;

import org.sid.Ecommerce.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
      Optional<Category> findByCode(String code);

}
