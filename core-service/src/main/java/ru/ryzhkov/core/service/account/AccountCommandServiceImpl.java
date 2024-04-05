package ru.ryzhkov.core.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryzhkov.common.domain.model.Account;
import ru.ryzhkov.common.events.AccountCreateEvent;
import ru.ryzhkov.core.service.event.EventService;


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
