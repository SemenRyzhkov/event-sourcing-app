package ru.ryzhkov.common.service.client;

import ru.ryzhkov.common.domain.model.Client;
import ru.ryzhkov.common.service.QueryService;

import java.util.UUID;

public interface ClientQueryService extends QueryService<Client> {

    Client getByUsername(String username);

    boolean existsByUsername(String username);

    Client getByAccount(
            UUID accountId
    );
}