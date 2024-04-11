package com.cityList.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {
            Exception.class})
    public ResponseEntity<?> handleInvalidTopUpTypeException(Exception ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {
        CityNoFoundException.class})
    public ResponseEntity<?> handleCityNotFountException(Exception ex) {
        return new ResponseEntity(String.format("can not found city by id : %s", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
