package com.epam.jwd.core_final.exception;

public class CrewMemberIsNotAssignedException extends RuntimeException{
    public CrewMemberIsNotAssignedException() {
    }

    public CrewMemberIsNotAssignedException(String message) {
        super(message);
    }
}
