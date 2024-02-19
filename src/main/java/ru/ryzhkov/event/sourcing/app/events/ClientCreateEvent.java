package ru.ryzhkov.event.sourcing.app.events;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ryzhkov.event.sourcing.app.domain.aggregate.Aggregate;
import ru.ryzhkov.event.sourcing.app.domain.model.Client;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientCreateEvent extends AbstractEvent {

    public ClientCreateEvent(final Client payload) {
        super(null, EventType.CLIENT_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {
        //TODO implement
    }

}