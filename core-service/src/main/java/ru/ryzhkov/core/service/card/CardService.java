package ru.ryzhkov.core.service.card;

import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.core.service.CommandService;
import ru.ryzhkov.core.service.QueryService;

import java.util.UUID;

public interface CardService extends CommandService<Card>, QueryService<Card> {

    void createByClientId(UUID clientId);

    boolean existsByNumberAndDate(
            String number,
            String date
    );

    Card getByNumberAndDateAndCvv(
            String number,
            String date,
            String cvv
    );

}