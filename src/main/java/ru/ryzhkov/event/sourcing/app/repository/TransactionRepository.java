package ru.ryzhkov.event.sourcing.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryzhkov.event.sourcing.app.domain.model.Transaction;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}