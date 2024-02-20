package ru.ryzhkov.event.sourcing.app.service.account;

import ru.ryzhkov.event.sourcing.app.domain.model.Account;
import ru.ryzhkov.event.sourcing.app.service.CommandService;

public interface AccountCommandService extends CommandService<Account> {
}
