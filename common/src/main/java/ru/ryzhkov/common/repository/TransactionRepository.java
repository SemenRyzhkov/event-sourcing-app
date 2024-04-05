package ru.ryzhkov.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryzhkov.common.domain.model.Transaction;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}