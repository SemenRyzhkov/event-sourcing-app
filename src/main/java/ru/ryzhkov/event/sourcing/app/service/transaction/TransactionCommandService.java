package ru.ryzhkov.event.sourcing.app.service.transaction;

import ru.ryzhkov.event.sourcing.app.domain.model.Transaction;
import ru.ryzhkov.event.sourcing.app.service.CommandService;

public interface TransactionCommandService extends CommandService<Transaction> {
}
