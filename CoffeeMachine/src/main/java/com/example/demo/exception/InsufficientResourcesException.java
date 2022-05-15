package com.example.demo.exception;

public class InsufficientResourcesException extends Exception {

    public InsufficientResourcesException() {
        super();
    }

    public InsufficientResourcesException(final String message) {
        super(message);
    }

    public InsufficientResourcesException(final Throwable throwable) {
        super(throwable);
    }
}
