package com.interview.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponses> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException)
    {
        String message = resourceNotFoundException.getMessage();
        ApiResponses apiResponses = new ApiResponses(message,false);
        return new ResponseEntity<>(apiResponses, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponses> handleApiException(ApiException apiException)
    {
        String message = apiException.getMessage();
        ApiResponses apiResponses = new ApiResponses(message,false);
        return new ResponseEntity<>(apiResponses,HttpStatus.BAD_REQUEST);
    }
}
