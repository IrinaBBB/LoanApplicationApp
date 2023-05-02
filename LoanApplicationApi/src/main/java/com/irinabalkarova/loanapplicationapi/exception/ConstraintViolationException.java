package com.irinabalkarova.loanapplicationapi.exception;

public class ConstraintViolationException extends Exception {
    public ConstraintViolationException() {
    }

    public ConstraintViolationException(String message) {
        super(message);
    }
}
