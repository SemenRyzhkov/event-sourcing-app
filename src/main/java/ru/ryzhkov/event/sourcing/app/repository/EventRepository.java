package ru.ryzhkov.event.sourcing.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryzhkov.event.sourcing.app.events.AbstractEvent;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}

