package app.game.model;

/**
 * Created by james on 11/26/16.
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
    public final GameProperty spaceType;

    public BoardSpace(String name) {
        this.name = name;
        spaceType = getSpaceType();
    }

    private GameProperty getSpaceType() {
        switch(name) {
            case KITCHEN:
            case BALLROOM:
            case CONSERVATORY:
            case DINING_ROOM:
            case BILLIARD_ROOM:
            case LIBRARY:
            case LOUNGE:
            case HALL:
            case STUDY:
                return GameProperty.ROOM;
            case SCARLET_START:
            case MUSTARD_START:
            case WHITE_START:
            case GREEN_START:
            case PEACOCK_START:
            case PLUM_START:
                return GameProperty.START_SPACE;
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
                return GameProperty.START_SPACE;
            default:
                // TODO consider throwing an exception instead??
                return null;
        }
    }
}
