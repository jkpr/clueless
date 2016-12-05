package app.json;

/**
 * Created by james on 11/30/16.
 */
public class TurnPayload {
    String who;
    boolean hasMoved;
    boolean hasSuggested;
    String whoCanDisprove;
    String suggestedCharacter;
    String suggestedWeapon;
    String suggestedRoom;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean getHasSuggested() {
        return hasSuggested;
    }

    public void setHasSuggested(boolean hasSuggested) {
        this.hasSuggested = hasSuggested;
    }

    public String getWhoCanDisprove() {
        return whoCanDisprove;
    }

    public void setWhoCanDisprove(String whoCanDisprove) {
        this.whoCanDisprove = whoCanDisprove;
    }

    public String getSuggestedCharacter() {
        return suggestedCharacter;
    }

    public void setSuggestedCharacter(String suggestedCharacter) {
        this.suggestedCharacter = suggestedCharacter;
    }

    public String getSuggestedWeapon() {
        return suggestedWeapon;
    }

    public void setSuggestedWeapon(String suggestedWeapon) {
        this.suggestedWeapon = suggestedWeapon;
    }

    public String getSuggestedRoom() {
        return suggestedRoom;
    }

    public void setSuggestedRoom(String suggestedRoom) {
        this.suggestedRoom = suggestedRoom;
    }

    @Override
    public String toString() {
        return String.format("who: %s, hasMoved: %s, hasSuggested: %s, whoCanDisprove: %s, suggestedCharacter: %s, suggestedWeapon: %s, suggestedRoom: %s",
                who, String.valueOf(hasMoved), String.valueOf(hasSuggested), whoCanDisprove, suggestedCharacter, suggestedWeapon, suggestedRoom);
    }
}
