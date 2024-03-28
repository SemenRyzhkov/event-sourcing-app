package ru.ryzhkov.event.sourcing.app.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ryzhkov.event.sourcing.app.domain.model.Client;
import ru.ryzhkov.event.sourcing.app.service.auth.AuthService;
import ru.ryzhkov.event.sourcing.app.web.dto.ClientDto;
import ru.ryzhkov.event.sourcing.app.web.dto.LoginRequestDto;
import ru.ryzhkov.event.sourcing.app.web.dto.LoginResponseDto;
import ru.ryzhkov.event.sourcing.app.web.dto.OnCreate;
import ru.ryzhkov.event.sourcing.app.web.dto.mapper.ClientMapper;

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
