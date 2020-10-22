package com.lamina.stock.exception;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement(name = "error")
public class ErrorResponse {
    final private String title;
    final private LocalDateTime timeStamp;
    final private List<String> description;

    public ErrorResponse(String title, List<String> description) {
        this.title = title;
        this.description = description;
        this.timeStamp = LocalDateTime.now();
    }
    public String getTitle() {
        return title;
    }
    public List<String> getDescription() {
        return description;
    }
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
