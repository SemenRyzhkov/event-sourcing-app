package ru.ryzhkov.core.service.transaction;

import ru.ryzhkov.common.domain.model.Transaction;
import ru.ryzhkov.core.service.CommandService;
import ru.ryzhkov.core.service.QueryService;

public interface TransactionService extends CommandService<Transaction>, QueryService<Transaction> {
}
