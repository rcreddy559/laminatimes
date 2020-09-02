package com.lamina.holidays.exception;

public class HolidaysNotFoundException extends RuntimeException {

    public HolidaysNotFoundException(String message) {
        super(message);
    }
}
