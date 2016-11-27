package app.game;

/**
 * Created by james on 11/26/16.
 */
public class BoardSpace {

    private BoardSpace(){}

    // Nine rooms
    public static final int KITCHEN = 0;
    public static final int BALLROOM = 1;
    public static final int CONSERVATORY = 2;
    public static final int DINING_ROOM = 3;
    public static final int BILLIARD_ROOM = 4;
    public static final int LIBRARY = 5;
    public static final int LOUNGE = 6;
    public static final int HALL = 7;
    public static final int STUDY = 8;

    // Six start squares
    public static final int SCARLET_START = 10;
    public static final int MUSTARD_START = 11;
    public static final int WHITE_START = 12;
    public static final int GREEN_START = 13;
    public static final int PEACOCK_START = 14;
    public static final int PLUM_START = 15;

    // Twelve hallways
    public static final int HALL__STUDY = 20;
    public static final int HALL__LOUNGE = 21;
    public static final int LIBRARY__STUDY = 22;
    public static final int BILLIARD_ROOM__HALL = 23;
    public static final int DINING_ROOM__LOUNGE = 24;
    public static final int BILLIARD_ROOM__LIBRARY = 25;
    public static final int BILLIARD_ROOM__DINING_ROOM = 26;
    public static final int CONSERVATORY__LIBRARY = 27;
    public static final int BALLROOM__BILLIARD_ROOM = 28;
    public static final int DINING_ROOM__KITCHEN = 29;
    public static final int BALLROOM__CONSERVATORY = 30;
    public static final int BALLROOM__KITCHEN = 31;

    // Three types
    public static final int ROOM = 40;
    public static final int HALLWAY = 41;
    public static final int START_SPACE = 42;

    public static int getType(int spaceName) {
        switch (spaceName) {
            case KITCHEN:
            case BALLROOM:
            case CONSERVATORY:
            case DINING_ROOM:
            case BILLIARD_ROOM:
            case LIBRARY:
            case LOUNGE:
            case HALL:
            case STUDY:
                return ROOM;
            case SCARLET_START:
            case MUSTARD_START:
            case WHITE_START:
            case GREEN_START:
            case PEACOCK_START:
            case PLUM_START:
                return START_SPACE;
            case HALL__STUDY:
            case HALL__LOUNGE:
            case LIBRARY__STUDY:
            case BILLIARD_ROOM__HALL:
            case DINING_ROOM__LOUNGE:
            case BILLIARD_ROOM__LIBRARY:
            case BILLIARD_ROOM__DINING_ROOM:
            case CONSERVATORY__LIBRARY:
            case BALLROOM__BILLIARD_ROOM:
            case DINING_ROOM__KITCHEN:
            case BALLROOM__CONSERVATORY:
            case BALLROOM__KITCHEN:
                return HALLWAY;
            default:
                // error
                return -1;
        }
    }

}
