/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Author: Rajanpreet Kaur, Jasmine Saini, Anshika Thakral, Nitika Patel
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;                // Name of the player
    private List<Card> hand;            // List to hold the player's hand of cards

    // Constructor
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    // Method to play a card from the hand
    public Card playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(hand.size() - 1);  // Play the top card
        }
        return null;  // No cards left to play
    }

    // Method to add a card to the player's hand
    public void addCard(Card card) {
        hand.add(card);
    }

    // Method to get the size of the hand
    public int getHandSize() {
        return hand.size();
    }

    // Getter for player's name
    public String getName() {
        return name;
    }
}
