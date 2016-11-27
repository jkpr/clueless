package app.game.model;

/**
 * Created by james on 11/27/16.
 */
public enum Card {
    // Rooms
    KITCHEN (GameProperty.ROOM),
    BALLROOM (GameProperty.ROOM),
    CONSERVATORY (GameProperty.ROOM),
    DINING_ROOM (GameProperty.ROOM),
    BILLIARD_ROOM (GameProperty.ROOM),
    LIBRARY (GameProperty.ROOM),
    LOUNGE (GameProperty.ROOM),
    HALL (GameProperty.ROOM),
    STUDY (GameProperty.ROOM),

    // Characters
    MS_SCARLET (GameProperty.CHARACTER),
    COL_MUSTARD (GameProperty.CHARACTER),
    MRS_WHITE (GameProperty.CHARACTER),
    MR_GREEN (GameProperty.CHARACTER),
    MRS_PEACOCK (GameProperty.CHARACTER),
    PROF_PLUM (GameProperty.CHARACTER),

    // Weapons
    CANDLESTICK (GameProperty.WEAPON),
    KNIFE (GameProperty.WEAPON),
    PIPE (GameProperty.WEAPON),
    REVOLVER (GameProperty.WEAPON),
    ROPE (GameProperty.WEAPON),
    WRENCH (GameProperty.WEAPON);

    public final GameProperty cardType;

    Card(GameProperty property) {
        cardType = property;
    }
}
