package ru.ryzhkov.event.sourcing.app.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryzhkov.event.sourcing.app.events.AbstractEvent;
import ru.ryzhkov.event.sourcing.app.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public void create(final AbstractEvent event) {
        repository.save(event);
    }
}
