package com.colorcardonline.backend.exceptions;

public class ErrorResponse {
    int status;
    String message;

    long timestamp;

    public ErrorResponse() {
    }
    public ErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }
    public ErrorResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }
    public ErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public ErrorResponse setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
