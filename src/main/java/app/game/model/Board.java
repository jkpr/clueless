package app.game.model;

import app.exception.GameModelException;

import java.util.*;

import static app.game.model.BoardSpace.*;

/**
 * Created by james on 11/26/16.
 * Edited by chris on 11/27/16
 */
public class Board {
    // Six character tokens
    private final CharacterToken MS_SCARLET = new CharacterToken(CharacterToken.MS_SCARLET);
    private final CharacterToken COL_MUSTARD = new CharacterToken(CharacterToken.COL_MUSTARD);
    private final CharacterToken MRS_WHITE = new CharacterToken(CharacterToken.MRS_WHITE);
    private final CharacterToken MR_GREEN = new CharacterToken(CharacterToken.MR_GREEN);
    private final CharacterToken MRS_PEACOCK = new CharacterToken(CharacterToken.MRS_PEACOCK);
    private final CharacterToken PROF_PLUM = new CharacterToken(CharacterToken.PROF_PLUM);

    // Six weapon tokens
    private final WeaponToken CANDLESTICK = new WeaponToken(WeaponToken.CANDLESTICK);
    private final WeaponToken KNIFE = new WeaponToken(WeaponToken.KNIFE);
    private final WeaponToken PIPE = new WeaponToken(WeaponToken.PIPE);
    private final WeaponToken REVOLVER = new WeaponToken(WeaponToken.REVOLVER);
    private final WeaponToken ROPE = new WeaponToken(WeaponToken.ROPE);
    private final WeaponToken WRENCH = new WeaponToken(WeaponToken.WRENCH);

    // Nine rooms
    private final BoardSpace KITCHEN = new BoardSpace(BoardSpace.KITCHEN);
    private final BoardSpace BALLROOM = new BoardSpace(BoardSpace.BALLROOM);
    private final BoardSpace CONSERVATORY = new BoardSpace(BoardSpace.CONSERVATORY);
    private final BoardSpace DINING_ROOM = new BoardSpace(BoardSpace.DINING_ROOM);
    private final BoardSpace BILLIARD_ROOM = new BoardSpace(BoardSpace.BILLIARD_ROOM);
    private final BoardSpace LIBRARY = new BoardSpace(BoardSpace.LIBRARY);
    private final BoardSpace LOUNGE = new BoardSpace(BoardSpace.LOUNGE);
    private final BoardSpace HALL = new BoardSpace(BoardSpace.HALL);
    private final BoardSpace STUDY = new BoardSpace(BoardSpace.STUDY);

    // Six start squares
    private final BoardSpace SCARLET_START = new BoardSpace(BoardSpace.SCARLET_START);
    private final BoardSpace MUSTARD_START = new BoardSpace(BoardSpace.MUSTARD_START);
    private final BoardSpace WHITE_START = new BoardSpace(BoardSpace.WHITE_START);
    private final BoardSpace GREEN_START = new BoardSpace(BoardSpace.GREEN_START);
    private final BoardSpace PEACOCK_START = new BoardSpace(BoardSpace.PEACOCK_START);
    private final BoardSpace PLUM_START = new BoardSpace(BoardSpace.PLUM_START);

    // Twelve hallways
    private final BoardSpace HALL__STUDY = new BoardSpace(BoardSpace.HALL__STUDY);
    private final BoardSpace HALL__LOUNGE = new BoardSpace(BoardSpace.HALL__LOUNGE);
    private final BoardSpace LIBRARY__STUDY = new BoardSpace(BoardSpace.LIBRARY__STUDY);
    private final BoardSpace BILLIARD_ROOM__HALL = new BoardSpace(BoardSpace.BILLIARD_ROOM__HALL);
    private final BoardSpace DINING_ROOM__LOUNGE = new BoardSpace(BoardSpace.DINING_ROOM__LOUNGE);
    private final BoardSpace BILLIARD_ROOM__LIBRARY = new BoardSpace(BoardSpace.BILLIARD_ROOM__LIBRARY);
    private final BoardSpace BILLIARD_ROOM__DINING_ROOM = new BoardSpace(BoardSpace.BILLIARD_ROOM__DINING_ROOM);
    private final BoardSpace CONSERVATORY__LIBRARY = new BoardSpace(BoardSpace.CONSERVATORY__LIBRARY);
    private final BoardSpace BALLROOM__BILLIARD_ROOM = new BoardSpace(BoardSpace.BALLROOM__BILLIARD_ROOM);
    private final BoardSpace DINING_ROOM__KITCHEN = new BoardSpace(BoardSpace.DINING_ROOM__KITCHEN);
    private final BoardSpace BALLROOM__CONSERVATORY = new BoardSpace(BoardSpace.BALLROOM__CONSERVATORY);
    private final BoardSpace BALLROOM__KITCHEN = new BoardSpace(BoardSpace.BALLROOM__KITCHEN);

    Board() throws GameModelException {}

    public CharacterToken getCharacterToken(String name) throws GameModelException {
        switch(name) {
            case CharacterToken.MS_SCARLET:
                return MS_SCARLET;
            case CharacterToken.COL_MUSTARD:
                return COL_MUSTARD;
            case CharacterToken.MRS_WHITE:
                return MRS_WHITE;
            case CharacterToken.MR_GREEN:
                return MR_GREEN;
            case CharacterToken.MRS_PEACOCK:
                return MRS_PEACOCK;
            case CharacterToken.PROF_PLUM:
                return PROF_PLUM;
            default:
                throw new GameModelException(name);
        }
    }

    public WeaponToken getWeaponToken(String name) throws GameModelException {
        switch(name) {
            case WeaponToken.CANDLESTICK:
                return CANDLESTICK;
            case WeaponToken.KNIFE:
                return KNIFE;
            case WeaponToken.PIPE:
                return PIPE;
            case WeaponToken.REVOLVER:
                return REVOLVER;
            case WeaponToken.ROPE:
                return ROPE;
            case WeaponToken.WRENCH:
                return WRENCH;
            default:
                throw new GameModelException(name);
        }
    }

    public BoardSpace getBoardSpace(String name) throws GameModelException {
        switch(name) {
            case BoardSpace.KITCHEN:
                return KITCHEN;
            case BoardSpace.BALLROOM:
                return BALLROOM;
            case BoardSpace.CONSERVATORY:
                return CONSERVATORY;
            case BoardSpace.DINING_ROOM:
                return DINING_ROOM;
            case BoardSpace.BILLIARD_ROOM:
                return BILLIARD_ROOM;
            case BoardSpace.LIBRARY:
                return LIBRARY;
            case BoardSpace.LOUNGE:
                return LOUNGE;
            case BoardSpace.HALL:
                return HALL;
            case BoardSpace.STUDY:
                return STUDY;
            case BoardSpace.SCARLET_START:
                return SCARLET_START;
            case BoardSpace.MUSTARD_START:
                return MUSTARD_START;
            case BoardSpace.WHITE_START:
                return WHITE_START;
            case BoardSpace.GREEN_START:
                return GREEN_START;
            case BoardSpace.PEACOCK_START:
                return PEACOCK_START;
            case BoardSpace.PLUM_START:
                return PLUM_START;
            case BoardSpace.HALL__STUDY:
                return HALL__STUDY;
            case BoardSpace.HALL__LOUNGE:
                return HALL__LOUNGE;
            case BoardSpace.LIBRARY__STUDY:
                return LIBRARY__STUDY;
            case BoardSpace.BILLIARD_ROOM__HALL:
                return BILLIARD_ROOM__HALL;
            case BoardSpace.DINING_ROOM__LOUNGE:
                return DINING_ROOM__LOUNGE;
            case BoardSpace.BILLIARD_ROOM__LIBRARY:
                return BILLIARD_ROOM__LIBRARY;
            case BoardSpace.BILLIARD_ROOM__DINING_ROOM:
                return BILLIARD_ROOM__DINING_ROOM;
            case BoardSpace.CONSERVATORY__LIBRARY:
                return CONSERVATORY__LIBRARY;
            case BoardSpace.BALLROOM__BILLIARD_ROOM:
                return BALLROOM__BILLIARD_ROOM;
            case BoardSpace.DINING_ROOM__KITCHEN:
                return DINING_ROOM__KITCHEN;
            case BoardSpace.BALLROOM__CONSERVATORY:
                return BALLROOM__CONSERVATORY;
            case BoardSpace.BALLROOM__KITCHEN:
                return BALLROOM__KITCHEN;
            default:
                throw new GameModelException(name);
        }
    }

    public Set<BoardSpace> getSpaceConnections(String name) throws GameModelException {
        Set<BoardSpace> connections = new HashSet<>();
        switch(name) {
            case BoardSpace.KITCHEN:
                connections.add(DINING_ROOM__KITCHEN);
                connections.add(BALLROOM__KITCHEN);
                connections.add(STUDY);
                return connections;
            case BoardSpace.BALLROOM:
                // TODO continue on as in KITCHEN
				connections.add(BALLROOM__BILLIARD_ROOM);
				connections.add(BALLROOM__CONSERVATORY);
				connections.add(BALLROOM__KITCHEN);
				return connections;
            case BoardSpace.CONSERVATORY:
				connections.add(CONSERVATORY__LIBRARY);
				connections.add(BALLROOM__CONSERVATORY);
				connections.add(LOUNGE);
                return connections;
            case BoardSpace.DINING_ROOM:
				connections.add(DINING_ROOM__KITCHEN);
				connections.add(DINING_ROOM__LOUNGE);
				connections.add(BILLIARD_ROOM__DINING_ROOM);
                return connections;
            case BoardSpace.BILLIARD_ROOM:
				connections.add(BILLIARD_ROOM__DINING_ROOM);
				connections.add(BILLIARD_ROOM__HALL);
				connections.add(BILLIARD_ROOM__LIBRARY);
				connections.add(BALLROOM__BILLIARD_ROOM);
                return connections;
            case BoardSpace.LIBRARY:
				connections.add(LIBRARY__STUDY);
				connections.add(BILLIARD_ROOM__LIBRARY);
				connections.add(CONSERVATORY__LIBRARY);
                return connections;
            case BoardSpace.LOUNGE:
				connections.add(HALL__LOUNGE);
				connections.add(DINING_ROOM__LOUNGE);
				connections.add(CONSERVATORY);
                return connections;
            case BoardSpace.HALL:
				connections.add(HALL__LOUNGE);
				connections.add(HALL__STUDY);
				connections.add(BILLIARD_ROOM__HALL);
                return connections;
            case BoardSpace.STUDY:
				connections.add(HALL__STUDY);
				connections.add(LIBRARY__STUDY);
				connections.add(KITCHEN);
                return connections;
            case BoardSpace.SCARLET_START:
				connections.add(HALL__LOUNGE);
                return connections;
            case BoardSpace.MUSTARD_START:
				connections.add(DINING_ROOM__LOUNGE);
                return connections;
            case BoardSpace.WHITE_START:
				connections.add(BALLROOM__KITCHEN);
                return connections;
            case BoardSpace.GREEN_START:
				connections.add(BALLROOM__CONSERVATORY);
                return connections;
            case BoardSpace.PEACOCK_START:
				connections.add(CONSERVATORY__LIBRARY);
                return connections;
            case BoardSpace.PLUM_START:
				connections.add(LIBRARY__STUDY);
                return connections;
            case BoardSpace.HALL__STUDY:
				connections.add(HALL);
				connections.add(STUDY);
                return connections;
            case BoardSpace.HALL__LOUNGE:
				connections.add(HALL);
				connections.add(LOUNGE);
                return connections;
            case BoardSpace.LIBRARY__STUDY:
				connections.add(LIBRARY);
				connections.add(STUDY);
                return connections;
            case BoardSpace.BILLIARD_ROOM__HALL:
				connections.add(BILLIARD_ROOM);
				connections.add(HALL);
                return connections;
            case BoardSpace.DINING_ROOM__LOUNGE:
				connections.add(DINING_ROOM);
				connections.add(LOUNGE);
                return connections;
            case BoardSpace.BILLIARD_ROOM__LIBRARY:
				connections.add(BILLIARD_ROOM);
				connections.add(LIBRARY);
                return connections;
            case BoardSpace.BILLIARD_ROOM__DINING_ROOM:
				connections.add(BILLIARD_ROOM);
				connections.add(DINING_ROOM);
                return connections;
            case BoardSpace.CONSERVATORY__LIBRARY:
				connections.add(CONSERVATORY);
				connections.add(LIBRARY);
                return connections;
            case BoardSpace.BALLROOM__BILLIARD_ROOM:
				connections.add(BALLROOM);
				connections.add(BILLIARD_ROOM);
                return connections;
            case BoardSpace.DINING_ROOM__KITCHEN:
				connections.add(DINING_ROOM);
				connections.add(KITCHEN);
                return connections;
            case BoardSpace.BALLROOM__CONSERVATORY:
				connections.add(BALLROOM);
				connections.add(CONSERVATORY);
                return connections;
            case BoardSpace.BALLROOM__KITCHEN:
				connections.add(BALLROOM);
				connections.add(KITCHEN);
                return connections;
            default:
                throw new GameModelException(name);
        }
    }

    public Set<BoardSpace> getSpaceConnections(BoardSpace space) throws GameModelException {
        return getSpaceConnections(space.name);
    }

    public Set<CharacterToken> getSpaceOccupants(String name) {
        // TODO: check all the character tokens if they point to this board space name
        // stub
        Set<CharacterToken> occupants = new HashSet<>();

        if (MS_SCARLET.getCurrentSpace().name.equals(name))
            occupants.add(MS_SCARLET);

        if (COL_MUSTARD.getCurrentSpace().name.equals(name))
            occupants.add(COL_MUSTARD);

        if (MRS_WHITE.getCurrentSpace().name.equals(name))
            occupants.add(MRS_WHITE);

        if (MR_GREEN.getCurrentSpace().name.equals(name))
            occupants.add(MR_GREEN);

        if (MRS_PEACOCK.getCurrentSpace().name.equals(name))
            occupants.add(MRS_PEACOCK);

        if (PROF_PLUM.getCurrentSpace().name.equals(name))
            occupants.add(PROF_PLUM);

        return occupants;
    }

    public Set<CharacterToken> getSpaceOccupants(BoardSpace space) {
        return getSpaceOccupants(space.name);
    }
}
