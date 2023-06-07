package org.sid.Ecommerce.Services.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.sid.Ecommerce.Dao.ArticleRepository;
import org.sid.Ecommerce.Dto.ArticleDto;
import org.sid.Ecommerce.Entity.Article;
import org.sid.Ecommerce.Exception.EntityNotFoundException;
import org.sid.Ecommerce.Exception.ErrorCode;
import org.sid.Ecommerce.Exception.InvalidEntityException;
import org.sid.Ecommerce.Services.ArticleService;
import org.sid.Ecommerce.Validators.ArticleValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
       List<String>errors= ArticleValidator.ValidateArticle(articleDto);
       if(!errors.isEmpty()){
           log.error("Article is not valid {}", articleDto);
           throw new InvalidEntityException("larticle nest pas valide", ErrorCode.ARTICLE_NOT_VALID,errors);
       }
        return  ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id==null){
            log.error("Article Id is null");
        }
        Optional<Article> article=articleRepository.findById(id);
        ArticleDto dto=ArticleDto.fromEntity(article.get());

        return Optional
                .of(dto)
                .orElseThrow(()->new EntityNotFoundException("Aucun Article avec l'Id"+id,ErrorCode.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)){
            log.error("Article code is null");
        }
        Optional<Article> article=articleRepository.findByCodeArticle(codeArticle);

        return Optional
                .of(ArticleDto.fromEntity(article.get()))
                .orElseThrow(
                ()->new EntityNotFoundException("Aucun Aricle avec se code"+codeArticle,ErrorCode.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll()
                .stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Id Article is null");
        }
        articleRepository.deleteById(id);

    }
}
