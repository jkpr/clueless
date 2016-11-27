package app.game.model;

import app.exception.GameModelException;

/**
 * Created by james on 11/27/16.
 */
public enum GameProperty {
    CHARACTER,
    WEAPON,
    ROOM,
    HALLWAY,
    START_SPACE;

    static GameProperty getType(String name) throws GameModelException {
        switch(name) {
            case CharacterToken.MS_SCARLET:
            case CharacterToken.COL_MUSTARD:
            case CharacterToken.MRS_WHITE:
            case CharacterToken.MR_GREEN:
            case CharacterToken.MRS_PEACOCK:
            case CharacterToken.PROF_PLUM:
                return CHARACTER;
            case WeaponToken.CANDLESTICK:
            case WeaponToken.KNIFE:
            case WeaponToken.PIPE:
            case WeaponToken.REVOLVER:
            case WeaponToken.ROPE:
            case WeaponToken.WRENCH:
                return WEAPON;
            case BoardSpace.KITCHEN:
            case BoardSpace.BALLROOM:
            case BoardSpace.CONSERVATORY:
            case BoardSpace.DINING_ROOM:
            case BoardSpace.BILLIARD_ROOM:
            case BoardSpace.LIBRARY:
            case BoardSpace.LOUNGE:
            case BoardSpace.HALL:
            case BoardSpace.STUDY:
                return ROOM;
            case BoardSpace.SCARLET_START:
            case BoardSpace.MUSTARD_START:
            case BoardSpace.WHITE_START:
            case BoardSpace.GREEN_START:
            case BoardSpace.PEACOCK_START:
            case BoardSpace.PLUM_START:
                return START_SPACE;
            case BoardSpace.HALL__STUDY:
            case BoardSpace.HALL__LOUNGE:
            case BoardSpace.LIBRARY__STUDY:
            case BoardSpace.BILLIARD_ROOM__HALL:
            case BoardSpace.DINING_ROOM__LOUNGE:
            case BoardSpace.BILLIARD_ROOM__LIBRARY:
            case BoardSpace.BILLIARD_ROOM__DINING_ROOM:
            case BoardSpace.CONSERVATORY__LIBRARY:
            case BoardSpace.BALLROOM__BILLIARD_ROOM:
            case BoardSpace.DINING_ROOM__KITCHEN:
            case BoardSpace.BALLROOM__CONSERVATORY:
            case BoardSpace.BALLROOM__KITCHEN:
                return HALLWAY;
            default:
                throw new GameModelException(name);
        }
    }
}
