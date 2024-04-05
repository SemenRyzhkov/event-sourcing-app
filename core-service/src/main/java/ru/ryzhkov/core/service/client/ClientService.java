package ru.ryzhkov.core.service.client;


import ru.ryzhkov.common.domain.model.Client;
import ru.ryzhkov.core.service.CommandService;
import ru.ryzhkov.core.service.QueryService;

public interface ClientService
        extends CommandService<Client>, QueryService<Client> {

    Client getByUsername(String username);

    boolean existsByUsername(String username);

}
