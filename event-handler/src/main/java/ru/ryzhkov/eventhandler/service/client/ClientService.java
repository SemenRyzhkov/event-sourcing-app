package ru.ryzhkov.eventhandler.service.client;

import jakarta.transaction.Transactional;
import ru.ryzhkov.common.domain.model.Client;

import java.util.UUID;

public interface ClientService {
    Client create(Client client);

    @Transactional
    void addCard(
            UUID clientId,
            UUID cardId
    );
}
