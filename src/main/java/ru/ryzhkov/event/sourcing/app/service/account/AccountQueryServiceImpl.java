package ru.ryzhkov.event.sourcing.app.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryzhkov.event.sourcing.app.domain.exception.ResourceNotFoundException;
import ru.ryzhkov.event.sourcing.app.domain.model.Account;
import ru.ryzhkov.event.sourcing.app.repository.AccountRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository repository;

    @Override
    public Account getById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
