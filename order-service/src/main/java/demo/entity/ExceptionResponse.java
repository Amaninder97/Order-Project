package demo.entity;

import java.time.LocalDateTime;


public class ExceptionResponse {

   

    private LocalDateTime timestamp;

    private String message;

    private String details;

    public ExceptionResponse(String message, String details) {
        
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}