package ru.ryzhkov.core.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.core.service.card.CardService;
import ru.ryzhkov.core.web.dto.CardDto;
import ru.ryzhkov.core.web.dto.TransactionDto;
import ru.ryzhkov.core.web.security.SecurityUser;
import ru.ryzhkov.core.web.security.service.SecurityService;
import ru.ryzhkov.core.web.dto.mapper.CardMapper;
import ru.ryzhkov.core.web.dto.mapper.TransactionMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;
    private final SecurityService securityService;

    @PostMapping
    public void create() {
        SecurityUser user = securityService.getUserFromRequest();
        cardService.createByClientId(user.getId());
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public List<TransactionDto> getTransactionsById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }

}
