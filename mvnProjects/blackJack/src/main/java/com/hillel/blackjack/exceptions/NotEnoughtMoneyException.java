package com.hillel.blackjack.exceptions;

public class NotEnoughtMoneyException extends RuntimeException {

    public NotEnoughtMoneyException(String message) {
        super(message);
    }
}
