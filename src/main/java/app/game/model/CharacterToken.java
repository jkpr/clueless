package app.game.model;

/**
 * Created by james on 11/26/16.
 */
public class CharacterToken {
    public static final String MS_SCARLET = "Ms. Scarlet";
    public static final String COL_MUSTARD = "Col. Mustard";
    public static final String MRS_WHITE = "Mrs. White";
    public static final String MR_GREEN = "Mr. Green";
    public static final String MRS_PEACOCK = "Mrs. Peacock";
    public static final String PROF_PLUM = "Prof. Plum";

    private final String name;
    private BoardSpace currentSpace;
    private boolean movedBySuggestion;

    public CharacterToken(String name) {
        this.name = name;
        currentSpace = null;
        movedBySuggestion = false;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        // TODO make string more descriptive
        return name;
    }

    public void setCurrentSpace(BoardSpace space) {
        currentSpace = space;
    }

    public BoardSpace getCurrentSpace() {
        return currentSpace;
    }

    public void setMovedBySuggestion(boolean moved) {
        movedBySuggestion = moved;
    }

    public boolean getMovedBySuggestion() {
        return movedBySuggestion;
    }
}
