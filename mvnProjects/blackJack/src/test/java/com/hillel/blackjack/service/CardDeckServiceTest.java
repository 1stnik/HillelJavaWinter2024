package com.hillel.blackjack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.hillel.blackjack.exceptions.CardDeckEmptyException;
import com.hillel.blackjack.exceptions.CardDeckTotalException;
import org.junit.jupiter.api.Test;

class CardDeckServiceTest {

    @Test
    void createOneDeck() {
        CardDeckService cds = new CardDeckService();
        cds.createDeck(1);
        assertEquals(52, cds.getTotalCardCount());
    }

    @Test
    void createEigthDeck() {
        CardDeckService cds = new CardDeckService();
        cds.createDeck(8);
        assertEquals(8 * 52, cds.getTotalCardCount());
    }

    @Test
    void createZeroDeckException() {
        CardDeckService cds = new CardDeckService();
        CardDeckTotalException cardDeckTotalException = assertThrows(CardDeckTotalException.class,
            () -> cds.createDeck(0));
        assertEquals("Number of deck must be between 1 to 8", cardDeckTotalException.getMessage());
    }

    @Test
    void createNineDeckException() {
        CardDeckService cds = new CardDeckService();
        CardDeckTotalException cardDeckTotalException = assertThrows(CardDeckTotalException.class,
            () -> cds.createDeck(9));
        assertEquals("Number of deck must be between 1 to 8", cardDeckTotalException.getMessage());
    }

    @Test
    void getCard() {
        CardDeckService cds = new CardDeckService();
        cds.createDeck(1);
        assertEquals(52, cds.getTotalCardCount());
        cds.getCard();
        assertEquals(51, cds.getTotalCardCount());
    }

    @Test
    void getCardEmptyException() {
        CardDeckService cds = new CardDeckService();
        CardDeckEmptyException cardDeckEmptyException = assertThrows(CardDeckEmptyException.class,
            () -> cds.getCard());
        assertEquals("No available card ....", cardDeckEmptyException.getMessage());
    }

}
