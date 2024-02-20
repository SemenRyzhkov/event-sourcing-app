package ru.ryzhkov.event.sourcing.app.service.card;

import ru.ryzhkov.event.sourcing.app.domain.model.Card;
import ru.ryzhkov.event.sourcing.app.service.CommandService;

public interface CardCommandService extends CommandService<Card> {
}
