package com.hillel.blackjack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.hillel.blackjack.dto.Card;
import com.hillel.blackjack.dto.GameResult;
import com.hillel.blackjack.dto.Rank;
import com.hillel.blackjack.dto.Suit;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameServiceTest {

    @Test
    @RepeatedTest(20)
    void calculateComputerScores() {
        GameService gs = new GameService();
        int result = gs.calculateComputerScores();
        assertTrue(result > 16);
        assertTrue(result < 26);

    }

    @Test
    void calculatePlayerScores() {
        Card card = new Card(Rank.Three, Suit.Diamonds);
        Card card1 = new Card(Rank.Seven, Suit.Diamonds);
        Card card2 = new Card(Rank.Ace, Suit.Diamonds);

        List<Card> hand = List.of(card, card1, card2);

        GameService gs = new GameService();
        assertEquals(21, gs.calculateHandScores(hand));

    }

    @Test
    void calculateBlackJack() {
        Card card = new Card(Rank.Ace, Suit.Diamonds);
        Card card2 = new Card(Rank.Ace, Suit.Diamonds);

        List<Card> hand = List.of(card, card2);

        GameService gs = new GameService();
        assertEquals(21, gs.calculateHandScores(hand));

    }

    @Test
    void getComputerHand(){
        CardDeckService cds = new CardDeckService();
        cds.createDeck(1);

        Stack<Card> deck = cds.getDeck();

        GameService gs = new GameService();
        List<Card> hand = gs.computerHand(deck);

        gs.printHand(hand);

        System.out.println();
        System.out.println("Total score : " + gs.calculateHandScores(hand));

    }

    @Test
    void getComputerHandAI(){
        CardDeckService cds = new CardDeckService();
        cds.createDeck(1);

        // Q♣ K♠ 8♦
        Card card = new Card(Rank.Queen, Suit.Diamonds);
        Card card1 = new Card(Rank.King, Suit.Diamonds);
        Card card2 = new Card(Rank.Seven, Suit.Diamonds);

        Stack<Card> deck = new Stack<>();
        deck.add(card);
        deck.add(card1);
        deck.add(card2);


//        Stack<Card> deck = cds.getDeck();

        GameService gs = new GameService();
        List<Card> hand = gs.computerHandAI(deck);

        gs.printHand(hand);

        System.out.println();
        System.out.println("Total score : " + gs.calculateHandScores(hand));

    }

    @Test
    void getComputerHandAI_repeat() {
        CardDeckService cds = new CardDeckService();
        cds.createDeck(1);
        Stack<Card> deck = cds.getDeck();

        GameService gs = new GameService();
        List<Card> hand = gs.computerHandAI(deck);

        gs.printHand(hand);

        System.out.println();
        System.out.println("Total score : " + gs.calculateHandScores(hand));

    }

    private static Stream<Arguments> dataGenerator() {
        return Stream.of(
           Arguments.of(20, 20, GameResult.DRAW),
           Arguments.of(25, 23, GameResult.LOSE),
           Arguments.of(21, 22, GameResult.PLAYER),
           Arguments.of(22, 21, GameResult.COMPUTER),
           Arguments.of(17, 18, GameResult.COMPUTER),
           Arguments.of(18, 17, GameResult.PLAYER)
        );
    }

    @ParameterizedTest
    @MethodSource("dataGenerator")
    void checkCalculateResult(Integer pScore, Integer cScore, GameResult result){
        GameService gs = new GameService();
        assertEquals(result, gs.calculateGameResult(cScore, pScore));
    }
}
