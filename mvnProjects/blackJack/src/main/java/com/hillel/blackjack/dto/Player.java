package com.hillel.blackjack.dto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public Player(String name, int numberOfGames) {
        this.name = name;
        this.numberOfGames = numberOfGames;
    }

    private String name;
    private int numberOfGames;

    private List<Card> hand = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
