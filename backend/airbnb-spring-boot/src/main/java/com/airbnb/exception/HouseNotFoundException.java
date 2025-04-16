package com.airbnb.exception;

/**
 * Exception thrown when a house is not found.
 */
public class HouseNotFoundException extends RuntimeException {
    private final long houseId;

    public HouseNotFoundException(String message, long houseId) {
        super(message);
        this.houseId = houseId;
    }

    public long getHouseId() {
        return this.houseId;
    }
}
