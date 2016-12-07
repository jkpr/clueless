package app.game.model;

import app.json.TurnPayload;

/**
 * Created by james on 11/29/16.
 */
public class Turn {
    private Player who;
    private boolean hasMoved;
    private boolean hasSuggested;
    private Player whoCanDisprove;
    private Card suggestedCharacter;
    private Card suggestedWeapon;
    private Card suggestedRoom;

    public Turn() {
        nextTurn(null);
    }

    public void nextTurn(Player next) {
        who = next;
        hasMoved = false;
        hasSuggested = false;
        whoCanDisprove = null;
        suggestedCharacter = null;
        suggestedWeapon = null;
        suggestedRoom = null;
    }

    public Player getWho() {
        return who;
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public boolean getHasSuggested() {
        return hasSuggested;
    }

    public Player getWhoCanDisprove() {
        return whoCanDisprove;
    }

    public Card getSuggestedCharacter() {
        return suggestedCharacter;
    }

    public Card getSuggestedWeapon() {
        return suggestedWeapon;
    }

    public Card getSuggestedRoom() {
        return suggestedRoom;
    }

    public void setWho(Player who) {
        this.who = who;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public void setHasSuggested(boolean hasSuggested) {
        this.hasSuggested = hasSuggested;
    }

    public void setWhoCanDisprove(Player whoCanDisprove) {
        this.whoCanDisprove = whoCanDisprove;
    }

    public void setSuggestedCharacter(Card suggestedCharacter) {
        this.suggestedCharacter = suggestedCharacter;
    }

    public void setSuggestedWeapon(Card suggestedWeapon) {
        this.suggestedWeapon = suggestedWeapon;
    }

    public void setSuggestedRoom(Card suggestedRoom) {
        this.suggestedRoom = suggestedRoom;
    }

    public String toVisualString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turn information: ");
        if (who == null) {
            sb.append("game not yet started so no turn info");
        } else {
            sb.append(who.getCharacter().getName());
            sb.append(".");
            if (hasMoved) {
                sb.append(" Has moved.");
            }
            if (hasSuggested) {
                sb.append(" Has suggested.");
            }
            if (suggestedCharacter != null) {
                sb.append("\n Current suggestion: ");
                sb.append(String.join(", ", suggestedCharacter.name, suggestedWeapon.name, suggestedRoom.name));
                sb.append(". Who can disprove: ");
                if (whoCanDisprove == null) {
                    sb.append("no one");
                } else {
                    sb.append(whoCanDisprove.getCharacter().getName());
                }
            }
        }
        return sb.toString();
    }

    public TurnPayload toPayload() {
        TurnPayload payload = new TurnPayload();
        if (who != null) {
            payload.setWho(who.getCharacter().getName());
        }
        payload.setHasMoved(hasMoved);
        payload.setHasSuggested(hasSuggested);
        if (whoCanDisprove != null) {
            payload.setWhoCanDisprove(whoCanDisprove.getCharacter().getName());
        }
        if (suggestedCharacter != null) {
            payload.setSuggestedCharacter(suggestedCharacter.name);
            payload.setSuggestedWeapon(suggestedWeapon.name);
            payload.setSuggestedRoom(suggestedRoom.name);
        }
        return payload;
    }

    public void clearSuggestion() {
        whoCanDisprove = null;
        suggestedCharacter = null;
        suggestedWeapon = null;
        suggestedRoom = null;
    }
}
