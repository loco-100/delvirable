 /**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Author: Rajanpreet Kaur
 * Date: 2024-11-14
 */
package ca.sheridancollege.project;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Player {
    private String name;
    private Queue<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        hand.offer(card);
    }

    public Card playCard() {
        return hand.poll();
    }

    public int getHandSize() {
        return hand.size();
    }

    public void addCards(List<Card> cards) {
        hand.addAll(cards);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }
}
