package com.airbnb.exception;

/**
 * Exception thrown when a house is not found.
 */
public class HouseNotFoundException extends RuntimeException {
    public HouseNotFoundException(String message) {
        super(message);
    }
}
