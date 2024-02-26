package ru.ryzhkov.event.sourcing.app.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ryzhkov.event.sourcing.app.domain.model.Client;
import ru.ryzhkov.event.sourcing.app.service.client.ClientService;
import ru.ryzhkov.event.sourcing.app.web.dto.AccountDto;
import ru.ryzhkov.event.sourcing.app.web.dto.CardDto;
import ru.ryzhkov.event.sourcing.app.web.dto.ClientDto;
import ru.ryzhkov.event.sourcing.app.web.dto.mapper.AccountMapper;
import ru.ryzhkov.event.sourcing.app.web.dto.mapper.CardMapper;
import ru.ryzhkov.event.sourcing.app.web.dto.mapper.ClientMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;

    @GetMapping("/{id}")
    public ClientDto getById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return clientMapper.toDto(client);
    }

    @GetMapping("/{id}/cards")
    public List<CardDto> getCardsById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return cardMapper.toDto(client.getCards());
    }

    @GetMapping("/{id}/account")
    public AccountDto getAccountById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }

}
