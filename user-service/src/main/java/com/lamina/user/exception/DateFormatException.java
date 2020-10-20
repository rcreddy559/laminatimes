package com.lamina.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DateFormatException extends RuntimeException {
    public DateFormatException(String message) {
        super(message);
    }
}
