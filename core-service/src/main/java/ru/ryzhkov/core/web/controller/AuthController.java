package ru.ryzhkov.core.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ryzhkov.common.domain.model.Client;
import ru.ryzhkov.core.service.auth.AuthService;
import ru.ryzhkov.core.web.dto.ClientDto;
import ru.ryzhkov.core.web.dto.LoginRequestDto;
import ru.ryzhkov.core.web.dto.LoginResponseDto;
import ru.ryzhkov.core.web.dto.OnCreate;
import ru.ryzhkov.core.web.dto.mapper.ClientMapper;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final ClientMapper clientMapper;

    @PostMapping("/register")
    public void register(
            @RequestBody @Validated(OnCreate.class) final ClientDto dto
    ) {
        Client client = clientMapper.fromDto(dto);
        authService.register(client);
    }

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody @Validated final LoginRequestDto dto
    ) {
        return authService.login(dto);
    }

}
