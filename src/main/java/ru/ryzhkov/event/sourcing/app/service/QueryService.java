package ru.ryzhkov.event.sourcing.app.service;

import java.util.UUID;

public interface QueryService<T> {

    T getById(UUID id);

}