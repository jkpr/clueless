package app.game;

import app.game.model.Card;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by james on 11/26/16.
 */
public class Player {
    private String user;
    private Character character;
    private List<Card> hand;

    public Player() {
        hand = new LinkedList<>();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean acceptCard(Card card) {
        for (Iterator<Card> iter = hand.iterator(); iter.hasNext();) {
            Card next = iter.next();
            if (next.equals(card)) {
                return false;
            }
        }
        hand.add(card);
        return true;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
