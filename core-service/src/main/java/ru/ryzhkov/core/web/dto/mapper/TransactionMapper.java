package ru.ryzhkov.core.web.dto.mapper;


import org.mapstruct.Mapper;
import ru.ryzhkov.common.domain.model.Transaction;
import ru.ryzhkov.core.web.dto.TransactionDto;

@Mapper(componentModel = "spring")
public interface TransactionMapper
        extends Mappable<Transaction, TransactionDto> {
}
