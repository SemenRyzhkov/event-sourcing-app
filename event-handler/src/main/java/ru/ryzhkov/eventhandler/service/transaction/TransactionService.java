package ru.ryzhkov.eventhandler.service.transaction;

import ru.ryzhkov.common.domain.model.Transaction;

public interface TransactionService {
    Transaction create(Transaction transaction);
}
