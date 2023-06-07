package org.sid.Ecommerce.Services.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.sid.Ecommerce.Dao.ArticleRepository;
import org.sid.Ecommerce.Dao.ClientRepository;
import org.sid.Ecommerce.Dao.CommandeClientRepository;
import org.sid.Ecommerce.Dao.LigneCommandeClientRepository;
import org.sid.Ecommerce.Dto.CommandClientDto;
import org.sid.Ecommerce.Dto.LigneCommandClientDto;
import org.sid.Ecommerce.Dto.VenteDto;
import org.sid.Ecommerce.Entity.Article;
import org.sid.Ecommerce.Entity.Client;
import org.sid.Ecommerce.Entity.CommandClient;
import org.sid.Ecommerce.Entity.LigneCommandClient;
import org.sid.Ecommerce.Exception.EntityNotFoundException;
import org.sid.Ecommerce.Exception.ErrorCode;
import org.sid.Ecommerce.Exception.InvalidEntityException;
import org.sid.Ecommerce.Services.CommandClientService;
import org.sid.Ecommerce.Validators.CommandeClientValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandClientServiceImpl implements CommandClientService {
    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    public CommandClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }

    @Override
    public CommandClientDto save(CommandClientDto dto) {
        List<String> erros = CommandeClientValidator.ValidateCommandClient(dto);
        if (!erros.isEmpty()) {
            log.error("Command Client n'est pas Valide");
            throw new InvalidEntityException("La Command Client n'est pas Valide", ErrorCode.COMMANDE_CLIENT_NOT_VALID, erros);
        }
        Optional<Client> client = clientRepository.findById(dto.getClientDto().getId());
        if (!client.isPresent()) {
            log.warn("Client  with id {} not found in DB", dto.getClientDto().getId());
            throw new EntityNotFoundException("Client not found with id: " + dto.getClientDto().getId(), ErrorCode.CLIENT_NOT_FOUND);
        }
        // check if article exist in ligne  cmd
         if(dto.getLigneCommandClients() !=null){
            dto.getLigneCommandClients().forEach(ligneCmd->{
                Optional<Article> article=articleRepository.findById(ligneCmd.getArticle().getId());
            });
        }
        CommandClient saveCommandClient=commandeClientRepository.save(CommandClientDto.toEntity(dto));

         dto.getLigneCommandClients().forEach(ligCmdClt -> {
            LigneCommandClient ligneCommandeClient = LigneCommandClientDto.toEntity(ligCmdClt);
            ligneCommandeClient.setCommandClient(saveCommandClient);
            ligneCommandeClientRepository.save(ligneCommandeClient);
        });
        return CommandClientDto.fromEntity(saveCommandClient);
    }

    @Override
    public CommandClientDto findById(Integer id) {

        if (id==null){
            log.error("");
            return  null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandClientDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException("Aucun Commande Client avec se Id " + id, ErrorCode.COMMANDE_CLIENT_NOT_FOUND));

    }

    @Override
    public CommandClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun cmd n'a ete trouve dans la BDD", ErrorCode.VENTE_NOT_FOUND));

    }

    @Override
    public List<CommandClientDto> findAll() {

        return commandeClientRepository.findAll().
                stream().
                map(CommandClientDto::fromEntity).
                collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        commandeClientRepository.deleteById(id);
    }
}
