package ru.ryzhkov.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryzhkov.common.domain.model.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
