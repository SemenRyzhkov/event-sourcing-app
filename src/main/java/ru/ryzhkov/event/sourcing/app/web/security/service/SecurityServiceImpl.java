package ru.ryzhkov.event.sourcing.app.web.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.ryzhkov.event.sourcing.app.domain.exception.ResourceNotFoundException;
import ru.ryzhkov.event.sourcing.app.domain.model.Card;
import ru.ryzhkov.event.sourcing.app.domain.model.Client;
import ru.ryzhkov.event.sourcing.app.domain.model.Transaction;
import ru.ryzhkov.event.sourcing.app.service.card.CardService;
import ru.ryzhkov.event.sourcing.app.service.client.ClientService;
import ru.ryzhkov.event.sourcing.app.service.transaction.TransactionService;
import ru.ryzhkov.event.sourcing.app.web.security.SecurityUser;

import java.util.UUID;

@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final ClientService clientService;
    private final CardService cardService;
    private final TransactionService transactionService;

    @Override
    public SecurityUser getUserFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return (SecurityUser) authentication
                .getPrincipal();
    }

    @Override
    public boolean canAccessClient(final UUID clientId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        return clientId.equals(id);
    }

    @Override
    public boolean canAccessCard(final UUID cardId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Client client = clientService.getById(id);
        return client.getCards().stream()
                .anyMatch(card -> card.getId().equals(cardId));
    }

    @Override
    public boolean canAccessCard(final Card card) {
        try {
            Card foundCard = cardService.getByNumberAndDateAndCvv(
                    card.getNumber(),
                    card.getDate(),
                    card.getCvv()
            );
            return canAccessCard(foundCard.getId());
        } catch (ResourceNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean canAccessTransaction(final UUID transactionId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Client client = clientService.getById(id);
        Transaction transaction = transactionService.getById(transactionId);
        return client.getCards().contains(transaction.getFrom())
                || client.getCards().contains(transaction.getTo());
    }

}
