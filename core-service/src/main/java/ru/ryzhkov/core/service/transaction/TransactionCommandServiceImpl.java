package ru.ryzhkov.core.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ryzhkov.common.domain.model.Transaction;
import ru.ryzhkov.common.events.TransactionCreateEvent;
import ru.ryzhkov.core.service.event.EventService;


@Service
@RequiredArgsConstructor
@Transactional
public class TransactionCommandServiceImpl
        implements TransactionCommandService {

    private final EventService eventService;

    @Override
    public void create(final Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}
