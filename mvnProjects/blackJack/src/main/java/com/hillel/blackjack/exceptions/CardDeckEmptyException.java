package com.hillel.blackjack.exceptions;

public class CardDeckEmptyException extends RuntimeException {

    public CardDeckEmptyException(String message) {
        super(message);
    }
}
