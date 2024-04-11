package ru.ryzhkov.eventhandler.service.card;

import ru.ryzhkov.common.domain.model.Card;

import java.math.BigDecimal;
import java.util.UUID;

public interface CardService {
    Card getById(UUID id);

    Card create(Card card);

    void add(Card card, BigDecimal amount);
}
