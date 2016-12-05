package app.game.model;

import app.exception.GameModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by james on 11/26/16.
 */
public class Weapon extends Token {
    private static final Logger logger = LoggerFactory.getLogger(Weapon.class);

    public static final String CANDLESTICK = "Candlestick";
    public static final String KNIFE = "Knife";
    public static final String PIPE = "Pipe";
    public static final String REVOLVER = "Revolver";
    public static final String ROPE = "Rope";
    public static final String WRENCH = "Wrench";

    public Weapon(String name) throws GameModelException {
        super(name);
    }

    public char toChar() {
        switch(getName()) {
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
                logger.warn("Unknown Weapon name: {}", getName());
                return '*';
        }
    }
}
