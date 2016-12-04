package app.game.model;

import app.exception.GameModelException;

/**
 * Created by james on 11/26/16.
 */

/*
5.8 BoardSpace
This class represents each component of the board, i.e the room or hallway. Secret
passages are not represented in the design, they only provide connections between
one board space and another.
 */

public class BoardSpace {
    // Nine rooms
    public static final String KITCHEN = "Kitchen";
    public static final String BALLROOM = "Ballroom";
    public static final String CONSERVATORY = "Conservatory";
    public static final String DINING_ROOM = "Dining room";
    public static final String BILLIARD_ROOM = "Billiard room";
    public static final String LIBRARY = "Library";
    public static final String LOUNGE = "Lounge";
    public static final String HALL = "Hall";
    public static final String STUDY = "Study";

    // Six start squares
    public static final String SCARLET_START = "Scarlet start";
    public static final String MUSTARD_START = "Mustard start";
    public static final String WHITE_START = "White start";
    public static final String GREEN_START = "Green start";
    public static final String PEACOCK_START = "Peacock start";
    public static final String PLUM_START = "Plum start";

    // Twelve hallways
    public static final String HALL__STUDY = "Hall-Study";
    public static final String HALL__LOUNGE = "Hall-Lounge";
    public static final String LIBRARY__STUDY = "Library-Study";
    public static final String BILLIARD_ROOM__HALL = "Billiard room-Hall";
    public static final String DINING_ROOM__LOUNGE = "Dining room-Lounge";
    public static final String BILLIARD_ROOM__LIBRARY = "Billiard room-Library";
    public static final String BILLIARD_ROOM__DINING_ROOM = "Billiard room-Dining room";
    public static final String CONSERVATORY__LIBRARY = "Conservatory-Library";
    public static final String BALLROOM__BILLIARD_ROOM = "Ballroom-Billiard room";
    public static final String DINING_ROOM__KITCHEN = "Dining room-Kitchen";
    public static final String BALLROOM__CONSERVATORY = "Ballroom-Conservatory";
    public static final String BALLROOM__KITCHEN = "Ballroom-Kitchen";

    public final String name;
    public final GameProperty type;

    public BoardSpace(String name) throws GameModelException {
        this.name = name;
        type = GameProperty.getType(name);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof BoardSpace) {
            BoardSpace other = (BoardSpace) obj;
            equal = name.equals(other.name);
        }

        return equal;
    }

}
