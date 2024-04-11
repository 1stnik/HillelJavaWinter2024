package com.cityList.exception;

public class CityNoFoundException extends RuntimeException{

    public CityNoFoundException(String message) {
        super(message);
    }
}
