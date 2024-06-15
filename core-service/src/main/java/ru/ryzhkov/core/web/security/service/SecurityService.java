package ru.ryzhkov.core.web.security.service;

import ru.ryzhkov.core.web.dto.CardDto;
import ru.ryzhkov.core.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(CardDto card);

    boolean canAccessTransaction(UUID transactionId);

}