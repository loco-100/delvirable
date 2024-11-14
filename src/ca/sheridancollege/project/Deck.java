 /**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Author: Rajanpreet Kaur
 * Date: 2024-11-14
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;  // List of cards in the deck

    // Constructor
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();  // Initialize the deck with cards
    }

    // Method to initialize the deck with cards
    public void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));  // Create a new card and add it to the deck
            }
        }
    }

    // Method to shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);  // Shuffle the cards in the deck
    }

    // Method to deal a card
    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);  // Remove and return the top card
        }
        return null;  // Return null if no cards are left
    }

    // Method to get the current list of cards
    public List<Card> getCards() {
        return cards;  // Return the list of cards
    }
}