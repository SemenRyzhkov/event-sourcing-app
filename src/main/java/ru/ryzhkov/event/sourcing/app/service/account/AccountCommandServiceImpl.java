package ru.ryzhkov.event.sourcing.app.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryzhkov.event.sourcing.app.domain.model.Account;
import ru.ryzhkov.event.sourcing.app.events.AccountCreateEvent;
import ru.ryzhkov.event.sourcing.app.service.event.EventService;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(final Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
}
