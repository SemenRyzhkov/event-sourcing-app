package ru.ryzhkov.event.sourcing.app.web.dto.mapper;

import org.mapstruct.Mapper;
import ru.ryzhkov.event.sourcing.app.domain.model.Account;
import ru.ryzhkov.event.sourcing.app.web.dto.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}