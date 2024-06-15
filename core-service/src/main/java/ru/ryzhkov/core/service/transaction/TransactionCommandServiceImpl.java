package ru.ryzhkov.core.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.common.domain.model.Transaction;
import ru.ryzhkov.common.events.TransactionCreateEvent;
import ru.ryzhkov.core.service.card.CardService;
import ru.ryzhkov.core.service.event.EventService;


@Service
@RequiredArgsConstructor
@Transactional
public class TransactionCommandServiceImpl
        implements TransactionCommandService {

    private final EventService eventService;
    private final CardService cardService;

    @Override
    public void create(final Transaction object) {
        Card from = cardService.getByNumberAndDateAndCvv(
                object.getFrom().getNumber(),
                object.getFrom().getDate(),
                object.getFrom().getCvv()
        );
        Card to = cardService.getByNumberAndDate(
                object.getTo().getNumber(),
                object.getTo().getDate()
        );
        object.setFrom(from);
        object.setTo(to);
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}
