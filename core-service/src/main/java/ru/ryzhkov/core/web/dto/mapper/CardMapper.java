package ru.ryzhkov.core.web.dto.mapper;

import org.mapstruct.Mapper;
import ru.ryzhkov.common.domain.model.Card;
import ru.ryzhkov.core.web.dto.CardDto;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
