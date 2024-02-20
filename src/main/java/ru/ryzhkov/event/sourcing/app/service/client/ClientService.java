package ru.ryzhkov.event.sourcing.app.service.client;


import ru.ryzhkov.event.sourcing.app.domain.model.Client;
import ru.ryzhkov.event.sourcing.app.service.CommandService;
import ru.ryzhkov.event.sourcing.app.service.QueryService;

public interface ClientService
        extends CommandService<Client>, QueryService<Client> {

    Client getByUsername(String username);

    boolean existsByUsername(String username);

}
