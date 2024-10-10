/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Author: Rajanpreet Kaur
 * Date: 2024-10-09
 */
package ca.sheridancollege.project;

import java.util.Scanner;

public class Game {
    private Player player1;  // First player
    private Player player2;  // Second player
    private Deck deck;       // Deck of cards

    // Constructor
    public Game(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        deck = new Deck();
        deck.shuffle();  // Shuffle the deck before starting the game
    }

    // Method to start the game
    public void startGame() {
        // Deal cards to players
        while (deck.getCards().size() > 0) {
            player1.addCard(deck.dealCard());
            player2.addCard(deck.dealCard());
        }

        System.out.println("Game Starting...");
        playRound();
    }

    // Method to play a round of the game
    public void playRound() {
        while (player1.getHandSize() > 0 && player2.getHandSize() > 0) {
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            // Determine the winner of the round
            int result = compareCards(card1, card2);
            if (result > 0) {
                System.out.println(player1.getName() + " wins this round!");
                player1.addCard(card1);  // Add both cards to winner's hand
                player1.addCard(card2);
            } else if (result < 0) {
                System.out.println(player2.getName() + " wins this round!");
                player2.addCard(card1);
                player2.addCard(card2);
            } else {
                System.out.println("It's a tie! Initiating war...");
                // Add tie logic here if needed
            }

            System.out.println("Remaining Cards - " + player1.getName() + ": " + player1.getHandSize() +
                    " | " + player2.getName() + ": " + player2.getHandSize());
        }

        checkForWinner();  // Check for the overall winner after rounds are complete
    }

    // Method to compare two cards and determine the winner
    private int compareCards(Card card1, Card card2) {
        return card1.getRank().compareTo(card2.getRank());  // Modify as per your game rules
    }

    // Method to check for a winner
    public void checkForWinner() {
        if (player1.getHandSize() > player2.getHandSize()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player2.getHandSize() > player1.getHandSize()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("The game is a tie!");
        }
    }

    // Main method to run the game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();

        Game game = new Game(player1Name, player2Name);
        game.startGame();
        scanner.close();
    }
}
