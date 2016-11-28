package app.game.model;

/**
 * Created by james on 11/26/16.
 */
public class CharacterToken implements Shortenable {
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

    public char toChar() {
        switch(name) {
            case MS_SCARLET:
                return 'S';
            case COL_MUSTARD:
                return 'M';
            case MRS_WHITE:
                return 'W';
            case MR_GREEN:
                return 'G';
            case MRS_PEACOCK:
                return 'K';
            case PROF_PLUM:
                return 'P';
            default:
                // TODO: Logger warning
                return '@';
        }
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

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof CharacterToken) {
            CharacterToken other = (CharacterToken) obj;
            boolean sameName = name.equals(other.getName());
            // check same space
            boolean thisNull = currentSpace == null;
            boolean otherNull = other.getCurrentSpace() == null;
            boolean bothNull = thisNull && otherNull;
            boolean bothNotNull = !thisNull && ! otherNull;
            boolean sameSpace = bothNull || (bothNotNull && currentSpace.equals(other.getCurrentSpace()));
            //
            boolean sameMovedBySuggestion = movedBySuggestion == other.getMovedBySuggestion();
            equal = sameName && sameSpace && sameMovedBySuggestion;
        }

        return equal;
    }
}
