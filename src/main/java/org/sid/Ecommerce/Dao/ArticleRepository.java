package org.sid.Ecommerce.Dao;

import org.sid.Ecommerce.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
   /* @Query("from Article a where a.codeArticle=:c and a.designation= :d")
    List<Article> findByCutomQuery(@Param("code") String  c , @Param("designation")String d);*/
   Optional<Article> findByCodeArticle(String code);
   List<Article> findAllByCategoryId(Integer idCategory);

}