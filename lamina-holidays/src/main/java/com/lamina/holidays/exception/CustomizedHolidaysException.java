package com.lamina.holidays.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class CustomizedHolidaysException {

    @ExceptionHandler(HolidaysNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> holidayNotFound(HolidaysNotFoundException exception, WebRequest request) {
        final ExceptionResponse response = new ExceptionResponse(LocalDate.now(),
                exception.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(HolidaysServiceException.class)
    public final ResponseEntity<ExceptionResponse> serviceException(HolidaysServiceException exception, WebRequest request) {
        final ExceptionResponse response = new ExceptionResponse(LocalDate.now(),
                exception.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
                request.getDescription(false), HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
