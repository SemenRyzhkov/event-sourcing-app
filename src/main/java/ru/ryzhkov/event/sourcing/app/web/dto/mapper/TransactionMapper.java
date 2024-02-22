package ru.ryzhkov.event.sourcing.app.web.dto.mapper;


import org.mapstruct.Mapper;
import ru.ryzhkov.event.sourcing.app.domain.model.Transaction;
import ru.ryzhkov.event.sourcing.app.web.dto.TransactionDto;

@Mapper(componentModel = "spring")
public interface TransactionMapper
        extends Mappable<Transaction, TransactionDto> {
}
