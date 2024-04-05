package ru.ryzhkov.core.service.auth;

import ru.ryzhkov.common.domain.model.Client;
import ru.ryzhkov.core.web.dto.LoginRequestDto;
import ru.ryzhkov.core.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto request);

    void register(Client client);

}
