package ru.ryzhkov.core.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryzhkov.common.events.AbstractEvent;
import ru.ryzhkov.common.repository.EventRepository;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public void create(final AbstractEvent event) {
        repository.save(event);
    }
}
