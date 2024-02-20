package ru.ryzhkov.event.sourcing.app.service.account;

import ru.ryzhkov.event.sourcing.app.domain.model.Account;
import ru.ryzhkov.event.sourcing.app.service.CommandService;
import ru.ryzhkov.event.sourcing.app.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {

}