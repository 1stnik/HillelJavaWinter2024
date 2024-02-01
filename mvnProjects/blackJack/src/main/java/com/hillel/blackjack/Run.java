package com.hillel.blackjack;

import com.hillel.blackjack.dto.Card;
import com.hillel.blackjack.dto.Player;
import com.hillel.blackjack.service.CardDeckService;
import com.hillel.blackjack.service.GameService;
import java.util.List;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        System.out.println("Welcome Black Jack : 2024");
        System.out.println("Please enter you name : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println( name + ": Please enter number of games [more then 0]: ");
        Integer gameCount = scanner.nextInt();
        scanner.nextLine();

        Player player = new Player(name, gameCount);

        CardDeckService cds = new CardDeckService();
        cds.createDeck(1);

        GameService gs =new GameService();

        String nextCard = "Y";

        do {
            List<Card> hand = player.getHand();

            // first time give 2 cards
            if (player.getHand().size() == 0){
                hand.add(cds.getCard());
            }
            hand.add(cds.getCard());

            // show hand and calculate score
            int score = gs.calculateHandScores(player.getHand());
            System.out.println("player hand : " + hand + " >>>> score: " + score);
            if (score < 21) {
                System.out.println("Next card ... [Y/N]");
                nextCard = scanner.nextLine();
            } else {
                break;
            }
            //check will we continue get card from deck
        } while (nextCard.equalsIgnoreCase("y"));

        System.out.println("player hand : " + player.getHand() + " >>>> score: " + gs.calculateHandScores(player.getHand()));

    }

}
