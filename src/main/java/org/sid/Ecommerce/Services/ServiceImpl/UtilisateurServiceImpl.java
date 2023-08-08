package org.sid.Ecommerce.Services.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.sid.Ecommerce.Dao.UtilisateurRepository;
import org.sid.Ecommerce.Dto.UtilisateurDto;
import org.sid.Ecommerce.Entity.Utilisateur;
import org.sid.Ecommerce.Exception.EntityNotFoundException;
import org.sid.Ecommerce.Exception.InvalidEntityException;
import org.sid.Ecommerce.Services.UtilisateurService;
import org.sid.Ecommerce.Validators.UtilisateurValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

  private UtilisateurRepository utilisateurRepository;


  @Autowired
  public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository ) {
    this.utilisateurRepository = utilisateurRepository;

  }

  @Override
  public UtilisateurDto save(UtilisateurDto dto) {
    List<String> errors = UtilisateurValidator.ValidateUtilisteur(dto);
    if (!errors.isEmpty()) {
      log.error("Utilisateur is not valid {}", dto);
    }


    return UtilisateurDto.fromEntity(
            utilisateurRepository.save(
                    UtilisateurDto.toEntity(dto)
            )
    );
  }


  @Override
  public UtilisateurDto findById(Integer id) {
    if (id == null) {
      log.error("Utilisateur ID is null");
      return null;
    }
    return utilisateurRepository.findById(id)
            .map(UtilisateurDto::fromEntity)
            .orElseThrow(() -> new EntityNotFoundException(
                    "Aucun utilisateur avec l'ID = " + id + " n' ete trouve dans la BDD")
            );
  }

  @Override
  public List<UtilisateurDto> findAll() {
    return utilisateurRepository.findAll().stream()
            .map(UtilisateurDto::fromEntity)
            .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Utilisateur ID is null");
      return;
    }
    utilisateurRepository.deleteById(id);
  }

}