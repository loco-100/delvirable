  /**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Author: Rajanpreet Kaur
 * Date: 2024-10-09
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;

    public Game(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        setupGame();
    }

    private void setupGame() {
        Deck deck = new Deck();
        List<Card> halfDeck1 = deck.dealHalfDeck();
        List<Card> halfDeck2 = deck.dealHalfDeck();

        for (Card card : halfDeck1) {
            player1.addCard(card);
        }
        for (Card card : halfDeck2) {
            player2.addCard(card);
        }
    }

    public void play() {
        int round = 1;

        while (player1.hasCards() && player2.hasCards()) {
            System.out.println("Round " + round + ":");
            Card p1Card = player1.playCard();
            Card p2Card = player2.playCard();

            System.out.println(player1.getName() + " plays: " + p1Card);
            System.out.println(player2.getName() + " plays: " + p2Card);

            int comparison = p1Card.compareRank(p2Card);

            if (comparison > 0) {
                System.out.println(player1.getName() + " wins the round.");
                player1.addCards(List.of(p1Card, p2Card));
            } else if (comparison < 0) {
                System.out.println(player2.getName() + " wins the round.");
                player2.addCards(List.of(p1Card, p2Card));
            } else {
                System.out.println("It's a tie! Going to war...");
                handleWar(p1Card, p2Card);
            }

            System.out.println(player1.getName() + " has " + player1.getHandSize() + " cards.");
            System.out.println(player2.getName() + " has " + player2.getHandSize() + " cards.");
            System.out.println();

            round++;
        }

        if (player1.hasCards()) {
            System.out.println(player1.getName() + " wins the game!");
        } else {
            System.out.println(player2.getName() + " wins the game!");
        }
    }

    private void handleWar(Card p1Card, Card p2Card) {
        List<Card> warPile = new ArrayList<>();
        warPile.add(p1Card);
        warPile.add(p2Card);

        for (int i = 0; i < 3; i++) {
            if (player1.hasCards()) {
                warPile.add(player1.playCard());
            }
            if (player2.hasCards()) {
                warPile.add(player2.playCard());
            }
        }

        if (player1.hasCards() && player2.hasCards()) {
            Card p1WarCard = player1.playCard();
            Card p2WarCard = player2.playCard();

            System.out.println(player1.getName() + " plays: " + p1WarCard + " (War card)");
            System.out.println(player2.getName() + " plays: " + p2WarCard + " (War card)");

            int comparison = p1WarCard.compareRank(p2WarCard);

            if (comparison > 0) {
                System.out.println(player1.getName() + " wins the war.");
                player1.addCards(warPile);
                player1.addCards(List.of(p1WarCard, p2WarCard));
            } else if (comparison < 0) {
                System.out.println(player2.getName() + " wins the war.");
                player2.addCards(warPile);
                player2.addCards(List.of(p1WarCard, p2WarCard));
            } else {
                System.out.println("The war ties! Adding more cards...");
                handleWar(p1WarCard, p2WarCard);
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game("Player 1", "Player 2");
        game.play();
    }
}
