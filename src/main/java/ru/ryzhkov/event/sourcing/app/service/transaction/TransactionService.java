package ru.ryzhkov.event.sourcing.app.service.transaction;

import ru.ryzhkov.event.sourcing.app.domain.model.Transaction;
import ru.ryzhkov.event.sourcing.app.service.CommandService;
import ru.ryzhkov.event.sourcing.app.service.QueryService;

public interface TransactionService extends CommandService<Transaction>, QueryService<Transaction> {
}
