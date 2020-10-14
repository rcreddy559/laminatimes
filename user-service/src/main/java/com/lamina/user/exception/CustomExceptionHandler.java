package com.lamina.user.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@Component
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    static Logger log = LogManager.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception e, WebRequest webRequest) {
        log.error("handleAllExceptions: {}", e.getLocalizedMessage());

        final ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "Server Error",
                Collections.singletonList(e.getLocalizedMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DateFormatException.class)
    public final ResponseEntity<ErrorResponse> dateFormatException(DateFormatException e, WebRequest webRequest) {
        log.error("dateFormatException: {}", e.getLocalizedMessage());

        final ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "Invalid Date",
                Collections.singletonList(e.getLocalizedMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserException.class)
    public final ResponseEntity<ErrorResponse> userException(UserException e, WebRequest webRequest) {
        log.error("dateFormatException: {}", e.getLocalizedMessage());

        final ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                "User not found",
                Collections.singletonList(e.getLocalizedMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
