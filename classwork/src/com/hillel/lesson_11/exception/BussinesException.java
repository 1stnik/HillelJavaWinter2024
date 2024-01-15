package com.hillel.lesson_11.exception;

import java.io.IOException;

public class BussinesException extends IOException {
    public BussinesException(String message) {
        super(message);
    }
}
