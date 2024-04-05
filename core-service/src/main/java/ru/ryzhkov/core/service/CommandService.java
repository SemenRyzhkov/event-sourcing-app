package ru.ryzhkov.core.service;

public interface CommandService<T> {

    void create(T object);

}
