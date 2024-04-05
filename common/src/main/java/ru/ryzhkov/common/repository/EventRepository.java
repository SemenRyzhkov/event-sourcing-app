package ru.ryzhkov.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryzhkov.common.events.AbstractEvent;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}

