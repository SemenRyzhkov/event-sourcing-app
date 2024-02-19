package ru.ryzhkov.event.sourcing.app.events;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ryzhkov.event.sourcing.app.domain.aggregate.Aggregate;
import ru.ryzhkov.event.sourcing.app.domain.model.Card;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CardCreateEvent extends AbstractEvent {

    public CardCreateEvent(final Card payload) {
        super(null, EventType.CARD_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {
        //TODO implement
    }

}