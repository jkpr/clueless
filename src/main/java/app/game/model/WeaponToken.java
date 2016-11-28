package app.game.model;

/**
 * Created by james on 11/26/16.
 */
public class WeaponToken implements Shortenable {
    public static final String CANDLESTICK = "Candlestick";
    public static final String KNIFE = "Knife";
    public static final String PIPE = "Pipe";
    public static final String REVOLVER = "Revolver";
    public static final String ROPE = "Rope";
    public static final String WRENCH = "Wrench";

    private final String name;
    private BoardSpace currentSpace;

    public WeaponToken(String name) {
        this.name = name;
        currentSpace = null;
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
            case CANDLESTICK:
                return 'c';
            case KNIFE:
                return 'k';
            case PIPE:
                return 'p';
            case REVOLVER:
                return 'v';
            case ROPE:
                return 'r';
            case WRENCH:
                return 'w';
            default:
                // TODO: Logger warning
                return '*';
        }
    }

    public void setCurrentSpace(BoardSpace space) {
        currentSpace = space;
    }

    public BoardSpace getCurrentSpace() {
        return currentSpace;
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
            equal = sameName && sameSpace;
        }

        return equal;
    }
}
