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
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> dealHalfDeck() {
        List<Card> halfDeck = new ArrayList<>(cards.subList(0, cards.size() / 2));
        cards.subList(0, cards.size() / 2).clear();
        return halfDeck;
    }
}
