package app.game.model;

/**
 * Created by james on 11/26/16.
 */
public class CardOLD {
    enum Value {
        // Rooms
        KITCHEN,
        BALLROOM,
        CONSERVATORY,
        DINING_ROOM,
        BILLIARD_ROOM,
        LIBRARY,
        LOUNGE,
        HALL,
        STUDY,

        // Characters
        MS_SCARLET,
        COL_MUSTARD,
        MRS_WHITE,
        MR_GREEN,
        MRS_PEACOCK,
        PROF_PLUM,

        // Weapons
        CANDLESTICK,
        KNIFE,
        PIPE,
        REVOLVER,
        ROPE,
        WRENCH
    }

    enum Type {
        ROOM,
        CHARACTER,
        WEAPON
    }

    Value value;

    public CardOLD(Value value) {
        this.value = value;
    }

    public Type getType() {
        switch(value) {
            case KITCHEN:
            case BALLROOM:
            case CONSERVATORY:
            case DINING_ROOM:
            case BILLIARD_ROOM:
            case LIBRARY:
            case LOUNGE:
            case HALL:
            case STUDY:
                return Type.ROOM;
            case MS_SCARLET:
            case COL_MUSTARD:
            case MRS_WHITE:
            case MR_GREEN:
            case MRS_PEACOCK:
            case PROF_PLUM:
                return Type.CHARACTER;
            case CANDLESTICK:
            case KNIFE:
            case PIPE:
            case REVOLVER:
            case ROPE:
            case WRENCH:
                return Type.WEAPON;
            default:
                return null;
        }
    }
}
