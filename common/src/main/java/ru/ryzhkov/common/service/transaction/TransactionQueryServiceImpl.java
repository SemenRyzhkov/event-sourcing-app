package ru.ryzhkov.common.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryzhkov.common.domain.exception.ResourceNotFoundException;
import ru.ryzhkov.common.domain.model.Transaction;
import ru.ryzhkov.common.repository.TransactionRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository repository;

    @Override
    public Transaction getById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}