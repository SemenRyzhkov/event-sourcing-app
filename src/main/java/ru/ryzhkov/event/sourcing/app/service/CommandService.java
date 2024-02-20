package ru.ryzhkov.event.sourcing.app.service;

public interface CommandService<T> {

    void create(T object);

}
