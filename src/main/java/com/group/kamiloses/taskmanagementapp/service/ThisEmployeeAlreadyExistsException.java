package com.group.kamiloses.taskmanagementapp.service;

public class ThisEmployeeAlreadyExistsException extends RuntimeException {
    public ThisEmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
