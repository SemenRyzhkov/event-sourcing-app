package ru.ryzhkov.event.sourcing.app.events;

import ru.ryzhkov.event.sourcing.app.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}