package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(PlantException.class)
    public ResponseEntity<PlantErrorResponse> fruitExceptionHandler(PlantException plantException){
            PlantErrorResponse plantErrorResponse = new PlantErrorResponse(plantException.getMessage());
        return new ResponseEntity<>(plantErrorResponse, plantException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PlantErrorResponse> ExceptionHandler(Exception exception){
            PlantErrorResponse plantErrorResponse = new PlantErrorResponse(exception.getMessage());
        return new ResponseEntity<>(plantErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
