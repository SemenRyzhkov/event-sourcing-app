package ru.ryzhkov.event.sourcing.app.service.event;

import ru.ryzhkov.event.sourcing.app.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);

}