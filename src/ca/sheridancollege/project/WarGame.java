package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WarGame {
    private WarPlayer player1;
    private WarPlayer player2;

    public WarGame(String player1Name, String player2Name) {
        player1 = new WarPlayer(player1Name);
        player2 = new WarPlayer(player2Name);
        setupGame();
    }

    private void setupGame() {
        GroupOfCards deck = new GroupOfCards();
        deck.shuffle();
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
                Queue<Card> wonCards = new LinkedList<>();
                wonCards.add(p1Card);
                wonCards.add(p2Card);
                player1.addCards(wonCards);
            } else if (comparison < 0) {
                System.out.println(player2.getName() + " wins the round.");
                Queue<Card> wonCards = new LinkedList<>();
                wonCards.add(p1Card);
                wonCards.add(p2Card);
                player2.addCards(wonCards);
            } else {
                System.out.println("It's a tie! Starting a war...");
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
                Queue<Card> wonCards = new LinkedList<>(warPile);
                wonCards.add(p1WarCard);
                wonCards.add(p2WarCard);
                player1.addCards(wonCards);
            } else if (comparison < 0) {
                System.out.println(player2.getName() + " wins the war.");
                Queue<Card> wonCards = new LinkedList<>(warPile);
                wonCards.add(p1WarCard);
                wonCards.add(p2WarCard);
                player2.addCards(wonCards);
            } else {
                System.out.println("The war ties! Adding more cards...");
                handleWar(p1WarCard, p2WarCard);
            }
        }
    }
}

