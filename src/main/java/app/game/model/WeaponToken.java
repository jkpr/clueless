package app.game.model;

/**
 * Created by james on 11/26/16.
 */
public class WeaponToken {
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

    public void setCurrentSpace(BoardSpace space) {
        currentSpace = space;
    }

    public BoardSpace getCurrentSpace() {
        return currentSpace;
    }
}
