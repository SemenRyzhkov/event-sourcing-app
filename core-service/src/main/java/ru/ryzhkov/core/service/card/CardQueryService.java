package ru.ryzhkov.core.service.card;

import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.core.service.QueryService;

public interface CardQueryService extends QueryService<Card> {

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