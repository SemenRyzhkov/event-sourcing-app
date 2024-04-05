package ru.ryzhkov.core.web.dto.mapper;

import org.mapstruct.Mapper;
import ru.ryzhkov.common.domain.model.Account;
import ru.ryzhkov.core.web.dto.AccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}