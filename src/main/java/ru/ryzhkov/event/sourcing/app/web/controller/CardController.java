package ru.ryzhkov.event.sourcing.app.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ryzhkov.event.sourcing.app.domain.model.Card;
import ru.ryzhkov.event.sourcing.app.service.card.CardService;
import ru.ryzhkov.event.sourcing.app.web.dto.CardDto;
import ru.ryzhkov.event.sourcing.app.web.dto.TransactionDto;
import ru.ryzhkov.event.sourcing.app.web.dto.mapper.CardMapper;
import ru.ryzhkov.event.sourcing.app.web.dto.mapper.TransactionMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {

    }

    @GetMapping("/{id}")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getTransactionsById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }

}
