package ru.ryzhkov.event.sourcing.app.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ryzhkov.event.sourcing.app.domain.model.Card;
import ru.ryzhkov.event.sourcing.app.events.CardCreateEvent;
import ru.ryzhkov.event.sourcing.app.service.event.EventService;

@Service
@RequiredArgsConstructor
@Transactional
public class CardCommandServiceImpl implements CardCommandService {

    private final EventService eventService;

    @Override
    public void create(final Card object) {
        CardCreateEvent event = new CardCreateEvent(object);
        eventService.create(event);
    }

}