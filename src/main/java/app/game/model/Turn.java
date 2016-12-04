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
}
