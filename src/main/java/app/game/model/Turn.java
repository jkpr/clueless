package app.game.model;

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
}
