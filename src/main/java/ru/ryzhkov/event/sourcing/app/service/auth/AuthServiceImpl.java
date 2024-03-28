package ru.ryzhkov.event.sourcing.app.service.auth;

import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ryzhkov.event.sourcing.app.domain.exception.ResourceAlreadyExistsException;
import ru.ryzhkov.event.sourcing.app.domain.model.Client;
import ru.ryzhkov.event.sourcing.app.service.client.ClientService;
import ru.ryzhkov.event.sourcing.app.web.dto.LoginRequestDto;
import ru.ryzhkov.event.sourcing.app.web.dto.LoginResponseDto;
import ru.ryzhkov.event.sourcing.app.web.security.jwt.JwtProperties;
import ru.ryzhkov.event.sourcing.app.web.security.jwt.TokenType;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;
    private final ClientService clientService;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto login(
            final LoginRequestDto request
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        LoginResponseDto response = new LoginResponseDto();
        response.setAccess(buildAccessToken(request));
        response.setRefresh(buildRefreshToken(request));
        return response;
    }

    private String buildRefreshToken(LoginRequestDto request) {
        return tokenService.create(
                TokenParameters.builder(
                                request.getUsername(),
                                TokenType.REFRESH.name(),
                                jwtProperties.getRefresh()
                        )
                        .build()
        );
    }

    private String buildAccessToken(LoginRequestDto request) {
        return tokenService.create(
                TokenParameters.builder(
                                request.getUsername(),
                                TokenType.ACCESS.name(),
                                jwtProperties.getAccess()
                        )
                        .build()
        );
    }

    @Override
    public void register(
            final Client client
    ) {
        if (clientService.existsByUsername(client.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.create(client);
    }

}