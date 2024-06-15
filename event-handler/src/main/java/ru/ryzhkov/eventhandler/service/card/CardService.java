package ru.ryzhkov.eventhandler.service.card;

import org.springframework.transaction.annotation.Transactional;
import ru.ryzhkov.common.domain.model.Card;

import java.math.BigDecimal;
import java.util.UUID;

public interface CardService {
    Card getById(UUID id);

    Card create(Card card);

    void add(Card card, BigDecimal amount);

    @Transactional
    void addTransaction(
            UUID cardId,
            UUID transactionId
    );
}
