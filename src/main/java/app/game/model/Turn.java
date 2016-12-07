package app.game.model;

/**
 * Created by james on 11/29/16.
 */

/*
5.14 Turn
The Turn class is an encapsulation of all Turn information. It could be merged into the
ClueLessModel since they are in a one-to-one composition relationship, but it is
important to separate the functionality and the attributes of a Turn from the
ClueLessModel class.
 */

public class Turn {
    private Player who;
    private boolean hasMoved;
    private boolean hasSuggested;
    private boolean movedBySuggestion;
    private boolean makeAccusation;
    private Player whoCanDisprove;
    private Card suggestedCharacter;
    private Card suggestedWeapon;
    private Card suggestedRoom;

    public Turn() {
        nextTurn(null);
    }

    /*
Operation name: NextTurn(next: CharacterToken)
Input: The next character token in the turn order
Output: void
Description: Sets this object’s CharacterToken to the next character token.
Sets HasMoved and HasSuggested to False.
     */

    public void nextTurn(Player next) {
        who = next;
        hasMoved = false;
        hasSuggested = false;
        movedBySuggestion = false;
        makeAccusation = false;
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

    public boolean getMovedBySuggestion() {
        return movedBySuggestion;
    }

    public void setMovedBySuggestion(boolean input){
        movedBySuggestion = input;
    }
    public boolean getMakeAccustaion(){
        return makeAccusation;
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
}
