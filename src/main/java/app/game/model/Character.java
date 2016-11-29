package app.game.model;

import app.exception.GameModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by james on 11/26/16.
 */
public class Character extends Token {
    private static final Logger logger = LoggerFactory.getLogger(Character.class);

    public static final String MS_SCARLET = "Ms. Scarlet";
    public static final String COL_MUSTARD = "Col. Mustard";
    public static final String MRS_WHITE = "Mrs. White";
    public static final String MR_GREEN = "Mr. Green";
    public static final String MRS_PEACOCK = "Mrs. Peacock";
    public static final String PROF_PLUM = "Prof. Plum";

    public Character(String name) throws GameModelException {
        super(name);
    }

    public char toChar() {
        switch(getName()) {
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
                logger.warn("Unknown CharacterToken name: {}", getName());
                return '@';
        }
    }
}
