package org.sid.Ecommerce.Services.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.sid.Ecommerce.Dao.ArticleRepository;
import org.sid.Ecommerce.Dao.CommandeFournisseurRepository;
import org.sid.Ecommerce.Dao.FournisseurRepository;
import org.sid.Ecommerce.Dao.LigneCommandeFournisseurRepository;
import org.sid.Ecommerce.Dto.CommandClientDto;
import org.sid.Ecommerce.Dto.CommandeFournisseurDto;
import org.sid.Ecommerce.Dto.LigneCommandClientDto;
import org.sid.Ecommerce.Dto.LigneCommandeFournisseurDto;
import org.sid.Ecommerce.Entity.*;
import org.sid.Ecommerce.Exception.EntityNotFoundException;
import org.sid.Ecommerce.Exception.ErrorCode;
import org.sid.Ecommerce.Exception.InvalidEntityException;
import org.sid.Ecommerce.Services.CommandFornisseurService;
import org.sid.Ecommerce.Validators.CommandeClientValidator;
import org.sid.Ecommerce.Validators.CommandeFournisseurValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j

public class CommandFornisseurServiceImpl implements CommandFornisseurService {
    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository ;

    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;
    public CommandFornisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository, FournisseurRepository fournisseurRepository, ArticleRepository articleRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.ValidateCommandFournisseur(dto);
        if (!errors.isEmpty()) {
            log.error("Fournisseur Client n'est pas Valide");
            throw new InvalidEntityException("La Command Client n'est pas Valide", ErrorCode.COMMANDE_CLIENT_NOT_VALID, errors);
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
        if (!fournisseur.isPresent()) {
            log.warn("Client  with id {} not found in DB", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Client not found with id: " + dto.getFournisseur().getId(), ErrorCode.CLIENT_NOT_FOUND);
        }
        // check if article exist in ligne  cmd
        if(dto.getLigneCommandFournisseurs() !=null){
            dto.getLigneCommandFournisseurs().forEach(ligneCmd->{
                Optional<Article> article=articleRepository.findById(ligneCmd.getArticle().getId());
            });
        }
        CommandFornisseur saveCommandFornisseur=commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

        dto.getLigneCommandFournisseurs().forEach(ligCmdFor -> {
            LigneCommandFournisseur ligneCommandFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmdFor);
            ligneCommandFournisseur.setCommandFornisseur(saveCommandFornisseur);
            ligneCommandeFournisseurRepository.save(ligneCommandFournisseur);
        });
        return CommandeFournisseurDto.fromEntity(saveCommandFornisseur);

    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {

        if (id==null){
            log.error("");
            return  null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException("Aucun Fornisseur Command avec se Id " + id, ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));

    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFornisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun cmd fornisseur n'a ete trouve dans la BDD", ErrorCode.VENTE_NOT_FOUND));

    }

    @Override
    public List<CommandeFournisseurDto> findAll() {

        return commandeFournisseurRepository.findAll().
                stream().
                map(CommandeFournisseurDto::fromEntity).
                collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        commandeFournisseurRepository.deleteById(id);

    }
}
