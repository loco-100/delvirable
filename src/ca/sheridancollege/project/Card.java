/**
 * SYST 17796 Project Base code.
 * @author Rajanpreet Kaur
 * 09-10-2024
 */
package ca.sheridancollege.project;

public class Card {
    private String rank;  // Rank of the card
    private String suit;  // Suit of the card

    // Constructor
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getter for rank
    public String getRank() {
        return rank;
    }

    // Getter for suit
    public String getSuit() {
        return suit;
    }

    // Method to return a string representation of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
