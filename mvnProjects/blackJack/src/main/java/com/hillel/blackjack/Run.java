package com.hillel.blackjack;

import com.hillel.blackjack.dto.Card;
import com.hillel.blackjack.dto.Computer;
import com.hillel.blackjack.dto.GameResult;
import com.hillel.blackjack.dto.Player;
import com.hillel.blackjack.exceptions.NotEnoughtMoneyException;
import com.hillel.blackjack.service.CardDeckService;
import com.hillel.blackjack.service.GameService;
import com.hillel.blackjack.service.MoneyService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Run {

    private static final Logger game = LoggerFactory.getLogger("game");
    private static final Logger result = LoggerFactory.getLogger("result");


    public static void main(String[] args) {

        ResourceBundle rb = ResourceBundle.getBundle("i10n",new Locale("ru", "UA"));

        System.out.println(rb.getString("welcome"));
        game.info("start game");
        System.out.println(rb.getString("name"));
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        game.info("user enter name {}", name);

        System.out.println(name + ":" + rb.getString("games"));
        Integer gameCount = scanner.nextInt();
        scanner.nextLine();
        game.info("user enter number of games {}", gameCount);
        System.out.println(rb.getString("money"));
        Integer amount = scanner.nextInt();
        game.info("user enter put money {}", amount);
        Player player = new Player(name, amount);
        Computer computer = new Computer();

        CardDeckService cds = new CardDeckService();
        cds.createDeck(1);

        GameService gs = new GameService();
        MoneyService ms = new MoneyService();

        String nextCard = "Y";
        String nextGame = "Y";

        int game = 1;

        do {
            System.out.println("---------------------->>>>>");
            System.out.println("Game " + game + " from " + gameCount);

            System.out.println("Please put your bet:");
            int bet =  scanner.nextInt();
            scanner.nextLine();

            try{
                ms.validateBet(bet, player.getAmount());
            } catch (NotEnoughtMoneyException ex){
                break;
            }

            game(player, cds, gs, scanner);

            computer.setHand(gs.computerHandAI(cds.getDeck()));

            int cScore = gs.calculateHandScores(computer.getHand());
            int pScore = gs.calculateHandScores(player.getHand());

            // print hands and scores
            System.out.println("===========");
            System.out.println("player hand : " + player.getHand() + " >>>> score: " + pScore);
            System.out.println("computer hand : " + computer.getHand() + " >>>> score: " + cScore);

            GameResult result = gs.calculateGameResult(cScore, pScore);
            System.out.println(result);

            player.incrementNumberOfGames();
            if (GameResult.PLAYER.equals(result)) {
                player.incrementNumberOfWinGames();
                player.add(bet);
            } else if (!GameResult.DRAW.equals(result)) {
                player.sub(bet);
            }

            player.setHand(new ArrayList<>());

            if (game++ != gameCount) {
                System.out.println("Next game ... [Y/N]");
                nextGame = scanner.nextLine();
            } else {
                break;
            }

        } while (nextGame.equalsIgnoreCase("y"));

        System.out.println(player.getPlayerResult());

    }

    private static void game(Player player, CardDeckService cds, GameService gs,
        Scanner scanner) {
        String nextCard;
        do {
            List<Card> hand = player.getHand();

            // first time give 2 cards
            if (player.getHand().size() == 0) {
                hand.add(cds.getCard());
            }
            hand.add(cds.getCard());

            // show hand and calculate score
            int score = gs.calculateHandScores(player.getHand());
            System.out.println("player hand : " + hand + " >>>> score: " + score);
            if (score < 21) {
                System.out.println("Next card ... [Y/N]");
                nextCard = scanner.nextLine();
                scanner.nextLine();
            } else {
                break;
            }
            //check will we continue get card from deck
        } while (nextCard.equalsIgnoreCase("y"));
    }

}
