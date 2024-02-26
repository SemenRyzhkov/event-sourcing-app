package ru.ryzhkov.event.sourcing.app.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ryzhkov.event.sourcing.app.domain.model.Transaction;
import ru.ryzhkov.event.sourcing.app.service.card.CardService;
import ru.ryzhkov.event.sourcing.app.service.transaction.TransactionService;
import ru.ryzhkov.event.sourcing.app.web.dto.OnCreate;
import ru.ryzhkov.event.sourcing.app.web.dto.TransactionDto;
import ru.ryzhkov.event.sourcing.app.web.dto.mapper.TransactionMapper;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create(@RequestBody @Validated(OnCreate.class) final TransactionDto dto) {
        if (!cardService.existsByNumberAndDate(
                dto.getTo().getNumber(),
                dto.getTo().getDate())
        ) {
            throw new IllegalStateException("Card does not exists.");
        }
        Transaction transaction = transactionMapper.fromDto(dto);
        transactionService.create(transaction);
    }

    @GetMapping("/{id}")
    public TransactionDto getById(@PathVariable final UUID id) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }

}