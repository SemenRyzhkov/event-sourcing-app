package ru.ryzhkov.eventhandler.service.client;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryzhkov.common.domain.model.Account;
import ru.ryzhkov.common.domain.model.Client;
import ru.ryzhkov.common.repository.ClientRepository;
import ru.ryzhkov.eventhandler.service.account.AccountService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final AccountService accountService;

    @Override
    @Transactional
    public Client create(final Client client) {
        Account account = new Account();
        account = accountService.create(account);
        client.setAccount(account);
        return repository.save(client);
    }

    @Override
    @Transactional
    public void addCard(final UUID clientId, final UUID cardId) {
        repository.addCard(clientId.toString(), cardId.toString());
    }

}