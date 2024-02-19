package ru.ryzhkov.event.sourcing.app.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(
            final String message
    ) {
        super(message);
    }

}