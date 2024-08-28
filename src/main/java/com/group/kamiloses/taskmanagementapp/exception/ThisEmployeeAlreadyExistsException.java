package com.group.kamiloses.taskmanagementapp.exception;

public class ThisEmployeeAlreadyExistsException extends RuntimeException {
    public ThisEmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
