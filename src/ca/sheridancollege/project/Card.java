/**
 * SYST 17796 Project Base code.
 * @author Rajanpreet Kaur
 * 09-10-2024
 */


package ca.sheridancollege.project;

import java.util.Objects;

public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public int compareRank(Card other) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int thisRank = java.util.Arrays.asList(ranks).indexOf(this.rank);
        int otherRank = java.util.Arrays.asList(ranks).indexOf(other.rank);
        return Integer.compare(thisRank, otherRank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank.equals(card.rank) && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
