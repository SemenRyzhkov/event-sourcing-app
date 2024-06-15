package ru.ryzhkov.eventhandler.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.common.domain.model.Transaction;
import ru.ryzhkov.common.repository.TransactionRepository;
import ru.ryzhkov.eventhandler.service.card.CardService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final CardService cardService;

    @Override
    @Transactional
    public Transaction create(
            final Transaction transaction
    ) {
        Card cardFrom = cardService.getById(transaction.getFrom().getId());
        Card cardTo = cardService.getById(transaction.getTo().getId());
        checkBalance(cardFrom, transaction.getAmount());
        cardService.add(cardFrom, transaction.getAmount().negate());
        cardService.add(cardTo, transaction.getAmount());
        repository.save(transaction);
        cardService.addTransaction(cardTo.getId(), transaction.getId());
        cardService.addTransaction(cardFrom.getId(), transaction.getId());
        return transaction;
    }

    private void checkBalance(
            final Card card,
            final BigDecimal amount
    ) {
        if (card.getAccount().getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money on card account.");
        }
    }

}