package ru.ryzhkov.eventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import ru.ryzhkov.common.domain.model.Transaction;
import ru.ryzhkov.common.events.TransactionCreateEvent;
import ru.ryzhkov.eventhandler.service.transaction.TransactionService;

@Component("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEventHandler implements EventHandler {

    private final TransactionService transactionService;
    private final Gson gson;

    @Override
    public void handle(
            final JsonObject object,
            final Acknowledgment acknowledgment
    ) {
        TransactionCreateEvent event = gson.fromJson(
                object,
                TransactionCreateEvent.class
        );
        Transaction transaction = gson.fromJson(
                (String) event.getPayload(),
                Transaction.class
        );
        transactionService.create(transaction);
        acknowledgment.acknowledge();
    }

}
