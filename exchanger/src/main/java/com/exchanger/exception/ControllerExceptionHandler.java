package com.exchanger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handleInvalidTopUpTypeException(Exception ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotUniqueDataException.class})
    public ResponseEntity<?> handleNonUniqueException(Exception ex) {
        return new ResponseEntity("You could not create user. Non unique values", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {WalletNotFoundException.class})
    public ResponseEntity<?> handleWalletNotFoundException(Exception ex) {
        return new ResponseEntity("You could not put money", HttpStatus.BAD_REQUEST);
    }


}
