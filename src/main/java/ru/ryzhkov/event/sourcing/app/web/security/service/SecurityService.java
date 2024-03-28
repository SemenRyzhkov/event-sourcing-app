package ru.ryzhkov.event.sourcing.app.web.security.service;

import ru.ryzhkov.event.sourcing.app.domain.model.Card;
import ru.ryzhkov.event.sourcing.app.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);

}