package com.airbnb.exception.user;

public class UserNotFountException extends RuntimeException {
    private final long userId;

    public  UserNotFountException(String message, long userId) {
        super(message);
        this.userId = userId;
    }
    public long getUserId() { return this.userId; }
}
