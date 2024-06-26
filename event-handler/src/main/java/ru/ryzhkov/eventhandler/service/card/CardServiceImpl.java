package ru.ryzhkov.eventhandler.service.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ryzhkov.common.domain.exception.ResourceNotFoundException;
import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.common.domain.model.Client;
import ru.ryzhkov.common.repository.CardRepository;
import ru.ryzhkov.common.service.client.ClientQueryService;
import ru.ryzhkov.eventhandler.service.client.ClientService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;
    private final ClientService clientService;
    private final ClientQueryService clientQueryService;

    @Override
    public Card getById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Card create(final Card card) {
        card.setCvv(generateCvv());
        card.setDate(generateDate());
        card.setNumber(generateNumber());
        repository.save(card);
        Client client = clientQueryService.getByAccount(
                card.getAccount().getId()
        );
        clientService.addCard(client.getId(), card.getId());
        return card;
    }

    private String generateCvv() {
        return String.valueOf(100 + (int) (Math.random() * 899));
    }

    private String generateDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = currentDate.plusYears(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        return expirationDate.format(formatter);
    }

    private String generateNumber() {
        return String.format(
                "%04d%04d%04d%04d",
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999)
        );
    }

    @Override
    @Transactional
    public void add(final Card card, final BigDecimal amount) {
        card.getAccount().setBalance(
                card.getAccount().getBalance().add(amount)
        );
        repository.save(card);
    }

    @Override
    @Transactional
    public void addTransaction(
            final UUID cardId,
            final UUID transactionId
    ) {
        repository.addTransaction(
                cardId.toString(),
                transactionId.toString()
        );
    }

}