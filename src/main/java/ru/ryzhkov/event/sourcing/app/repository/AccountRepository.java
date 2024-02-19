package ru.ryzhkov.event.sourcing.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryzhkov.event.sourcing.app.domain.model.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
