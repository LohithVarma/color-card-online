package com.colourcardonline.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // handle exceptions
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException exception){
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value()).
                setMessage(exception.getMessage()).
                setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(Exception exception){
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value()).
                setMessage(exception.getMessage()).
                setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
