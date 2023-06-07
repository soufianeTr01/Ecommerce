package org.sid.Ecommerce.Services.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.sid.Ecommerce.Dao.ArticleRepository;
import org.sid.Ecommerce.Dao.CategoryRepository;
import org.sid.Ecommerce.Dto.CategoryDto;
import org.sid.Ecommerce.Entity.Article;
import org.sid.Ecommerce.Entity.Category;
import org.sid.Ecommerce.Exception.EntityNotFoundException;
import org.sid.Ecommerce.Exception.ErrorCode;
import org.sid.Ecommerce.Exception.InvalidEntityException;
import org.sid.Ecommerce.Exception.InvalidOperationException;
import org.sid.Ecommerce.Services.CategoryService;
import org.sid.Ecommerce.Validators.CategoryValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.Validate(categoryDto);

        if (!errors.isEmpty()) {
            log.error("Category  is not valid {}", categoryDto);
            throw new InvalidEntityException("Category n' est pas  Valid ", ErrorCode.CATEGORY_NOT_VALID, errors);

        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Category id is null");
        }
        Optional<Category> category = categoryRepository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun Category avec se Id " + id, ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Category id is null");
        }
        Optional<Category> category = categoryRepository.findByCode(code);
        return Optional.of(CategoryDto.fromEntity(category.get()))
                .orElseThrow(() -> new EntityNotFoundException("Aucun Category avec se Code " + code, ErrorCode.CATEGORY_NOT_FOUND));


    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Category Id is null");
            return;
        }
        List<Article> articles = articleRepository.findAllByCategoryId(id);
        if (!articles.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
                    ErrorCode.CATEGORY_ALREADY_IN_USE);
        }
        categoryRepository.deleteById(id);

    }
}