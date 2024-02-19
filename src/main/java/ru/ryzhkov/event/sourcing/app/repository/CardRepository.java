package ru.ryzhkov.event.sourcing.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryzhkov.event.sourcing.app.domain.model.Card;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    boolean existsByNumberAndDate(
            String number,
            String date
    );

    Optional<Card> findByNumberAndDateAndCvv(
            String number,
            String date,
            String cvv
    );

}