package ru.ryzhkov.event.sourcing.app.service.auth;

import ru.ryzhkov.event.sourcing.app.domain.model.Client;
import ru.ryzhkov.event.sourcing.app.web.dto.LoginRequestDto;
import ru.ryzhkov.event.sourcing.app.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto request);

    void register(Client client);

}
