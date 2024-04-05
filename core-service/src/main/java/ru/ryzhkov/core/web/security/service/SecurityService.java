package ru.ryzhkov.core.web.security.service;

import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.core.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);

}