package org.sid.Ecommerce.Services.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.sid.Ecommerce.Dao.ArticleRepository;
import org.sid.Ecommerce.Dao.ClientRepository;
import org.sid.Ecommerce.Dao.CommandeClientRepository;
import org.sid.Ecommerce.Dto.ClientDto;
import org.sid.Ecommerce.Entity.CommandClient;
import org.sid.Ecommerce.Exception.EntityNotFoundException;
import org.sid.Ecommerce.Exception.ErrorCode;
import org.sid.Ecommerce.Exception.InvalidEntityException;
import org.sid.Ecommerce.Exception.InvalidOperationException;
import org.sid.Ecommerce.Services.ClientService;
import org.sid.Ecommerce.Validators.ClientValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private CommandeClientRepository commandeClientRepository;
    public ClientServiceImpl(ClientRepository clientRepository, CommandeClientRepository commandeClientRepository) {
        this.clientRepository = clientRepository;
        this.commandeClientRepository = commandeClientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {

        List<String> errors = ClientValidator.ValidateClient(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Le Client n'est pas valide", ErrorCode.CLIENT_NOT_VALID, errors);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        return clientRepository.findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun Client avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCode.CLIENT_NOT_FOUND)
                );
    }

    @Override
    public List<ClientDto> findAll() {

        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return;
        }
        List<CommandClient> commandeClients = commandeClientRepository.findAllByClientId(id);
        if(!commandeClients.isEmpty()){
            throw new InvalidOperationException(
                    "Impossible de supprimer un client qui a deja des commande clients",
                    ErrorCode.CLIENT_ALREADY_IN_USE);
        }

        clientRepository.deleteById(id);
    }

}
