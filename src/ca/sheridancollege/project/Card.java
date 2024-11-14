/**
 * SYST 17796 Project Base code.
 * @author Rajanpreet Kaur
 * 09-10-2024
 */
package ca.sheridancollege.project;

public class Card {
    // Define the properties of a Card, e.g., suit and rank
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getters for suit and rank
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
