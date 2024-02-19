package ru.ryzhkov.event.sourcing.app.events;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ryzhkov.event.sourcing.app.domain.aggregate.Aggregate;
import ru.ryzhkov.event.sourcing.app.domain.model.Transaction;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionCreateEvent extends AbstractEvent {

    public TransactionCreateEvent(final Transaction payload) {
        super(null, EventType.TRANSACTION_CREATE, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {
        //TODO implement
    }

}