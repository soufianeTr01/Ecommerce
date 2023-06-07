package org.sid.Ecommerce.Services.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.sid.Ecommerce.Dao.ArticleRepository;
import org.sid.Ecommerce.Dao.LigneVenteRepository;
import org.sid.Ecommerce.Dao.VentesRepository;
import org.sid.Ecommerce.Dto.LigneVenteDto;
import org.sid.Ecommerce.Dto.VenteDto;
import org.sid.Ecommerce.Entity.Article;
import org.sid.Ecommerce.Entity.LigneVentes;
import org.sid.Ecommerce.Entity.Ventes;
import org.sid.Ecommerce.Exception.EntityNotFoundException;
import org.sid.Ecommerce.Exception.ErrorCode;
import org.sid.Ecommerce.Exception.InvalidEntityException;
import org.sid.Ecommerce.Services.VentesService;
import org.sid.Ecommerce.Validators.VentesValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class VentesServiceImpl implements VentesService {
    private  VentesRepository ventesRepository;
    private LigneVenteRepository ligneVenteRepository;
    private ArticleRepository articleRepository;

    public VentesServiceImpl(VentesRepository ventesRepository, LigneVenteRepository ligneVenteRepository, ArticleRepository articleRepository) {
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public VenteDto save(VenteDto dto) {
           List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes N 'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCode.VENTE_NOT_VALID, errors);
        }
        // chek si larticle est null par ligne
        List<String>articlErrors=new ArrayList<>();
        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article=articleRepository.findById(ligneVenteDto.getArticle().getId());
            if(article.isEmpty()){
                articlErrors.add("Aucun Article avec lid  "+ligneVenteDto.getArticle().getId()+"n a pas trouver dans la bd ");
            }
        });
        if(!articlErrors.isEmpty()){
            log.error("One or more articles not found {}",errors);
            throw new InvalidEntityException("Un ou plusieur article ne pas trouver dans la bd", ErrorCode.VENTE_NOT_VALID, errors);

        }

        Ventes savedVentes=ventesRepository.save(VenteDto.toEntity(dto));
        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVentes ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVente(savedVentes);
            ligneVenteRepository.save(ligneVente);
        });
        return VenteDto.fromEntity(ventesRepository.save(VenteDto.toEntity(dto)));
    }

    @Override
    public VenteDto findById(Integer id) {

        if (id == null) {
            log.error("Ventes ID is NULL");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun vente n'a ete trouve dans la BDD", ErrorCode.VENTE_NOT_FOUND));
    }

    @Override
    public VenteDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return ventesRepository.findByCode(code)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun vente n'a ete trouve dans la BDD", ErrorCode.VENTE_NOT_FOUND));

    }

    @Override
    public List<VenteDto> findAll() {
      return   ventesRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return;
        }
        ventesRepository.deleteById(id);
        

    }
}

