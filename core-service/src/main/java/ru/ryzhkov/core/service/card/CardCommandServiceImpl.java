package ru.ryzhkov.core.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.common.events.CardCreateEvent;
import ru.ryzhkov.core.service.event.EventService;

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