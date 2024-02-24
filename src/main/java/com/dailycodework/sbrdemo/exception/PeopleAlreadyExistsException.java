package com.dailycodework.sbrdemo.exception;


public class PeopleAlreadyExistsException extends RuntimeException {
    public PeopleAlreadyExistsException(String message) {
        super(message);
    }
}
