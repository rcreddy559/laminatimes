package com.lamina.holidays.exception;

import java.time.LocalDate;

public class ExceptionResponse {

    private LocalDate date;
    private String message;
    private String details;
    private String httpCodeMessage;

    public ExceptionResponse(LocalDate date, String message, String details, String httpCodeMessage) {
        super();
        this.date = date;
        this.message = message;
        this.details = details;
        this.httpCodeMessage = httpCodeMessage;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public void setHttpCodeMessage(String httpCodeMessage) {
        this.httpCodeMessage = httpCodeMessage;
    }
}
