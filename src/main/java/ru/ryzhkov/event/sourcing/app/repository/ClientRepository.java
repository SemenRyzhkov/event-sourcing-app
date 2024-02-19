package ru.ryzhkov.event.sourcing.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryzhkov.event.sourcing.app.domain.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByUsername(String username);

    boolean existsByUsername(String username);

}