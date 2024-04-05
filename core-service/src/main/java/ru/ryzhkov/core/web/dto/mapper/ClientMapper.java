package ru.ryzhkov.core.web.dto.mapper;

import org.mapstruct.Mapper;
import ru.ryzhkov.common.domain.model.Client;
import ru.ryzhkov.core.web.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
