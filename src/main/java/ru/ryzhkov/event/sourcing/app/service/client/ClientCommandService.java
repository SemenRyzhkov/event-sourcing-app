package ru.ryzhkov.event.sourcing.app.service.client;

import ru.ryzhkov.event.sourcing.app.domain.model.Client;
import ru.ryzhkov.event.sourcing.app.service.CommandService;

public interface ClientCommandService extends CommandService<Client> {
}