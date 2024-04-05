package ru.ryzhkov.core.web.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.ryzhkov.common.domain.model.Client;
import ru.ryzhkov.core.service.client.ClientService;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final ClientService clientService;

    @Override
    public SecurityUser loadUserByUsername(
            final String username
    ) {
        Client client = clientService.getByUsername(username);
        return new SecurityUser(client);
    }

}