package ru.ryzhkov.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryzhkov.common.domain.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByUsername(String username);

    boolean existsByUsername(String username);

}