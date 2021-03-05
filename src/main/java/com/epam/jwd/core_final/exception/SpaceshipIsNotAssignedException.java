package com.epam.jwd.core_final.exception;

public class SpaceshipIsNotAssignedException extends RuntimeException{
    public SpaceshipIsNotAssignedException() {
    }

    public SpaceshipIsNotAssignedException(String message) {
        super(message);
    }
}
