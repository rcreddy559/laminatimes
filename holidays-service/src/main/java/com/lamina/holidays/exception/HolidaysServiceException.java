package com.lamina.holidays.exception;

public class HolidaysServiceException extends RuntimeException {
    HolidaysServiceException(String message) {
        super(message);
    }
}
