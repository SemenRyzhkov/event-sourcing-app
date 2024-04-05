package ru.ryzhkov.core.service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ryzhkov.common.domain.model.Client;
import ru.ryzhkov.common.events.ClientCreateEvent;
import ru.ryzhkov.core.service.event.EventService;


@Service
@RequiredArgsConstructor
@Transactional
public class ClientCommandServiceImpl implements ClientCommandService {

    private final EventService eventService;

    @Override
    public void create(
            final Client object
    ) {
        ClientCreateEvent event = new ClientCreateEvent(object);
        eventService.create(event);
    }

}