package app.json;

import java.util.List;

/**
 * Created by jpringle on 12/4/16.
 */
public class PlayerPayload {
    String character;
    String type;
    List<String> hand;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getHand() {
        return hand;
    }

    public void setHand(List<String> hand) {
        this.hand = hand;
    }
}
