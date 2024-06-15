package ru.ryzhkov.common.service.card;

import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.common.service.QueryService;

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

    Card getByNumberAndDate(
            String number,
            String date
    );
}