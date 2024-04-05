package ru.ryzhkov.common.events;


import ru.ryzhkov.common.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}