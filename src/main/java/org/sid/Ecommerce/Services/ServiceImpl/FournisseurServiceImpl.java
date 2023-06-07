package org.sid.Ecommerce.Services.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.sid.Ecommerce.Dao.CommandeFournisseurRepository;
import org.sid.Ecommerce.Dao.FournisseurRepository;
import org.sid.Ecommerce.Dto.FournisseurDto;
import org.sid.Ecommerce.Entity.CommandClient;
import org.sid.Ecommerce.Entity.CommandFornisseur;
import org.sid.Ecommerce.Entity.Fournisseur;
import org.sid.Ecommerce.Exception.EntityNotFoundException;
import org.sid.Ecommerce.Exception.ErrorCode;
import org.sid.Ecommerce.Exception.InvalidEntityException;
import org.sid.Ecommerce.Exception.InvalidOperationException;
import org.sid.Ecommerce.Services.FournisseurService;
import org.sid.Ecommerce.Validators.FournisseurValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepository fournisseurRepository;
    private CommandeFournisseurRepository commandeFournisseurRepository;
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository, CommandeFournisseurRepository commandeFournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
        this.commandeFournisseurRepository = commandeFournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.ValidateFournisseur(dto);
        if (!errors.isEmpty()) {
            log.error("Fournisseur is not valid {}", dto);
            throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCode.FOURNISSEUR_NOT_VALID, errors);
        }

        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(dto)));
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if(id==null){
            log.error("Fournisseur Id is null");
        }
        Optional<Fournisseur>fournisseur=fournisseurRepository.findById(id);
        FournisseurDto fournisseurDto =FournisseurDto.fromEntity(fournisseur.get());
        return Optional.of(fournisseurDto)
                .orElseThrow(()->new EntityNotFoundException("Aucun fournisseur avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCode.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Fournisseur ID is null");
            return;
        } List<CommandFornisseur> commandeFournisseur = commandeFournisseurRepository.findAllByFournisseurId(id);
        if (!commandeFournisseur.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un fournisseur qui a deja des commandes",
                    ErrorCode.FOURNISSEUR_ALREADY_IN_USE);
        }
        fournisseurRepository.deleteById(id);
    }
}
