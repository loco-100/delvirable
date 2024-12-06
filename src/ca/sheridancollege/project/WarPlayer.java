package ca.sheridancollege.project;


import java.util.LinkedList;
import java.util.Queue;

public class WarPlayer {
    private String name;
    private Queue<Card> hand;

    public WarPlayer(String name) {
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

    public void addCards(Queue<Card> cards) {
        hand.addAll(cards);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }
}



    
