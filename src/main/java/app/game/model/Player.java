package app.game.model;

import app.json.PlayerPayload;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by james on 11/26/16.
 */
public class Player {
    private Character character;
    private List<Card> hand;
    private boolean computerPlayer;
    private GameStatus status;

    public Player(Character character) {
        this.character = character;
        hand = new LinkedList<>();
        computerPlayer = false;
        status = GameStatus.SETUP;
    }

    public Player() {
        this.character = null;
        hand = new LinkedList<>();
        computerPlayer = false;
        status = GameStatus.SETUP;
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

    public boolean isComputerPlayer() {
        return computerPlayer;
    }

    public void setComputerPlayer(boolean computer) {
        computerPlayer = computer;
    }

    public boolean controls(Character character) {
        if (this.character == null) {
            return false;
        } else {
            return this.character.getName().equals(character.getName());
        }
    }

    public String toVisualString() {
        StringBuilder sb = new StringBuilder(32);
        if (character == null) {
            sb.append("Player not yet set");
        } else {
            sb.append(character.getName());
            sb.append(": ");
            List<String> handList = new ArrayList<>();
            for (Card card : hand) {
                handList.add(card.name);
            }
            sb.append(String.join(", ", handList));
            if (hand.isEmpty()) {
                sb.append("no cards yet");
            }
        }
        return sb.toString();
    }

    public PlayerPayload toPayload() {
        PlayerPayload payload = new PlayerPayload();
        // character
        if (character != null) {
            payload.setCharacter(character.getName());
        }
        // cards
        List<String> cards = new ArrayList<>();
        for (Card card : hand) {
            cards.add(card.name);
        }
        payload.setHand(cards);
        // computer
        if (computerPlayer) {
            payload.setType("computer");
        } else {
            payload.setType("human");
        }
        return payload;
    }

    public boolean isCharacterSet() {
        return character != null;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
}
