package com.epam.jwd.core_final.exception;

public class SpaceshipIsNotCreatedException extends RuntimeException {
    public SpaceshipIsNotCreatedException() {
    }

    public SpaceshipIsNotCreatedException(String message) {
        super(message);
    }
}
