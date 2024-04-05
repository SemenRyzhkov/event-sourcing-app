package ru.ryzhkov.core.service.event;


import ru.ryzhkov.common.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);

}