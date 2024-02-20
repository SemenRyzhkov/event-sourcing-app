package ru.ryzhkov.event.sourcing.app.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryzhkov.event.sourcing.app.domain.model.Client;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientQueryService queryService;
    private final ClientCommandService commandService;

    @Override
    public void create(final Client object) {
        commandService.create(object);
    }

    @Override
    public Client getById(final UUID id) {
        return queryService.getById(id);
    }

    @Override
    public Client getByUsername(final String username) {
        return queryService.getByUsername(username);
    }

    @Override
    public boolean existsByUsername(final String username) {
        return queryService.existsByUsername(username);
    }

}
