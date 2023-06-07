package org.sid.Ecommerce.Services;

import org.sid.Ecommerce.Dto.ArticleDto;
import org.sid.Ecommerce.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(Integer id);
    CategoryDto findByCode(String code);
    List<CategoryDto> findAll();
    void delete(Integer id);
}
