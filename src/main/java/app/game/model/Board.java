package app.game.model;

import app.exception.GameModelException;
import app.json.BoardPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by james on 11/26/16.
 * Edited by chris on 11/27/16
 */

/*
5.6 Board
The Board class determines the location of the character and weapons and also
connects the neighboring board spaces. The Board class does not worry about game
logic, e.g. for example it can place character tokens and weapon tokens anywhere. It
also does not know about player turns.
 */

public class Board {
    private static final Logger logger = LoggerFactory.getLogger(Board.class);

    // Six character tokens
    private Character msScarlet;
    private Character colMustard;
    private Character mrsWhite;
    private Character mrGreen;
    private Character mrsPeacock;
    private Character profPlum;

    // Six weapon tokens
    private Weapon candlestick;
    private Weapon knife;
    private Weapon pipe;
    private Weapon revolver;
    private Weapon rope;
    private Weapon wrench;

    // Nine rooms
    private BoardSpace kitchen;
    private BoardSpace ballroom;
    private BoardSpace conservatory;
    private BoardSpace diningRoom;
    private BoardSpace billiardRoom;
    private BoardSpace library;
    private BoardSpace lounge;
    private BoardSpace hall;
    private BoardSpace study;

    // Six start squares
    private BoardSpace scarletStart;
    private BoardSpace mustardStart;
    private BoardSpace whiteStart;
    private BoardSpace greenStart;
    private BoardSpace peacockStart;
    private BoardSpace plumStart;

    // Twelve hallways
    private BoardSpace hallStudy;
    private BoardSpace hallLounge;
    private BoardSpace libraryStudy;
    private BoardSpace billiardRoomHall;
    private BoardSpace diningRoomLounge;
    private BoardSpace billiardRoomLibrary;
    private BoardSpace billiardRoomDiningRoom;
    private BoardSpace conservatoryLibrary;
    private BoardSpace ballroomBilliardRoom;
    private BoardSpace diningRoomKitchen;
    private BoardSpace ballroomConservatory;
    private BoardSpace ballroomKitchen;

    public Board() {
        try {
            msScarlet = new Character(Character.MS_SCARLET);
            colMustard = new Character(Character.COL_MUSTARD);
            mrsWhite = new Character(Character.MRS_WHITE);
            mrGreen = new Character(Character.MR_GREEN);
            mrsPeacock = new Character(Character.MRS_PEACOCK);
            profPlum = new Character(Character.PROF_PLUM);
            candlestick = new Weapon(Weapon.CANDLESTICK);
            knife = new Weapon(Weapon.KNIFE);
            pipe = new Weapon(Weapon.PIPE);
            revolver = new Weapon(Weapon.REVOLVER);
            rope = new Weapon(Weapon.ROPE);
            wrench = new Weapon(Weapon.WRENCH);
            kitchen = new BoardSpace(BoardSpace.KITCHEN);
            ballroom = new BoardSpace(BoardSpace.BALLROOM);
            conservatory = new BoardSpace(BoardSpace.CONSERVATORY);
            diningRoom = new BoardSpace(BoardSpace.DINING_ROOM);
            billiardRoom = new BoardSpace(BoardSpace.BILLIARD_ROOM);
            library = new BoardSpace(BoardSpace.LIBRARY);
            lounge = new BoardSpace(BoardSpace.LOUNGE);
            hall = new BoardSpace(BoardSpace.HALL);
            study = new BoardSpace(BoardSpace.STUDY);
            scarletStart = new BoardSpace(BoardSpace.SCARLET_START);
            mustardStart = new BoardSpace(BoardSpace.MUSTARD_START);
            whiteStart = new BoardSpace(BoardSpace.WHITE_START);
            greenStart = new BoardSpace(BoardSpace.GREEN_START);
            peacockStart = new BoardSpace(BoardSpace.PEACOCK_START);
            plumStart = new BoardSpace(BoardSpace.PLUM_START);
            hallStudy = new BoardSpace(BoardSpace.HALL__STUDY);
            hallLounge = new BoardSpace(BoardSpace.HALL__LOUNGE);
            libraryStudy = new BoardSpace(BoardSpace.LIBRARY__STUDY);
            billiardRoomHall = new BoardSpace(BoardSpace.BILLIARD_ROOM__HALL);
            diningRoomLounge = new BoardSpace(BoardSpace.DINING_ROOM__LOUNGE);
            billiardRoomLibrary = new BoardSpace(BoardSpace.BILLIARD_ROOM__LIBRARY);
            billiardRoomDiningRoom = new BoardSpace(BoardSpace.BILLIARD_ROOM__DINING_ROOM);
            conservatoryLibrary = new BoardSpace(BoardSpace.CONSERVATORY__LIBRARY);
            ballroomBilliardRoom = new BoardSpace(BoardSpace.BALLROOM__BILLIARD_ROOM);
            diningRoomKitchen = new BoardSpace(BoardSpace.DINING_ROOM__KITCHEN);
            ballroomConservatory = new BoardSpace(BoardSpace.BALLROOM__CONSERVATORY);
            ballroomKitchen = new BoardSpace(BoardSpace.BALLROOM__KITCHEN);
        } catch (GameModelException e) {
            logger.error("Error thrown while constructing Board. Should never happen...");
        }
    }

    public Character getCharacter(String name) throws GameModelException {
        switch(name) {
            case Character.MS_SCARLET:
                return msScarlet;
            case Character.COL_MUSTARD:
                return colMustard;
            case Character.MRS_WHITE:
                return mrsWhite;
            case Character.MR_GREEN:
                return mrGreen;
            case Character.MRS_PEACOCK:
                return mrsPeacock;
            case Character.PROF_PLUM:
                return profPlum;
            default:
                throw new GameModelException(name);
        }
    }

    public Weapon getWeapon(String name) throws GameModelException {
        switch(name) {
            case Weapon.CANDLESTICK:
                return candlestick;
            case Weapon.KNIFE:
                return knife;
            case Weapon.PIPE:
                return pipe;
            case Weapon.REVOLVER:
                return revolver;
            case Weapon.ROPE:
                return rope;
            case Weapon.WRENCH:
                return wrench;
            default:
                throw new GameModelException(name);
        }
    }

    public List<Token> getAllCharacters() {
        List<Token> tokens = new LinkedList<>();
        tokens.add(msScarlet);
        tokens.add(colMustard);
        tokens.add(mrsWhite);
        tokens.add(mrGreen);
        tokens.add(mrsPeacock);
        tokens.add(profPlum);
        return tokens;
    }

    public List<Token> getAllWeapons() {
        List<Token> tokens = new LinkedList<>();
        tokens.add(candlestick);
        tokens.add(knife);
        tokens.add(pipe);
        tokens.add(revolver);
        tokens.add(rope);
        tokens.add(wrench);
        return tokens;
    }

    public List<BoardSpace> getAllRooms() {
        List<BoardSpace> rooms = new LinkedList<>();
        rooms.add(study);
        rooms.add(hall);
        rooms.add(lounge);
        rooms.add(library);
        rooms.add(billiardRoom);
        rooms.add(diningRoom);
        rooms.add(conservatory);
        rooms.add(ballroom);
        rooms.add(kitchen);
        return rooms;
    }

    public BoardSpace getBoardSpace(String name) throws GameModelException {
        switch(name) {
            case BoardSpace.KITCHEN:
                return kitchen;
            case BoardSpace.BALLROOM:
                return ballroom;
            case BoardSpace.CONSERVATORY:
                return conservatory;
            case BoardSpace.DINING_ROOM:
                return diningRoom;
            case BoardSpace.BILLIARD_ROOM:
                return billiardRoom;
            case BoardSpace.LIBRARY:
                return library;
            case BoardSpace.LOUNGE:
                return lounge;
            case BoardSpace.HALL:
                return hall;
            case BoardSpace.STUDY:
                return study;
            case BoardSpace.SCARLET_START:
                return scarletStart;
            case BoardSpace.MUSTARD_START:
                return mustardStart;
            case BoardSpace.WHITE_START:
                return whiteStart;
            case BoardSpace.GREEN_START:
                return greenStart;
            case BoardSpace.PEACOCK_START:
                return peacockStart;
            case BoardSpace.PLUM_START:
                return plumStart;
            case BoardSpace.HALL__STUDY:
                return hallStudy;
            case BoardSpace.HALL__LOUNGE:
                return hallLounge;
            case BoardSpace.LIBRARY__STUDY:
                return libraryStudy;
            case BoardSpace.BILLIARD_ROOM__HALL:
                return billiardRoomHall;
            case BoardSpace.DINING_ROOM__LOUNGE:
                return diningRoomLounge;
            case BoardSpace.BILLIARD_ROOM__LIBRARY:
                return billiardRoomLibrary;
            case BoardSpace.BILLIARD_ROOM__DINING_ROOM:
                return billiardRoomDiningRoom;
            case BoardSpace.CONSERVATORY__LIBRARY:
                return conservatoryLibrary;
            case BoardSpace.BALLROOM__BILLIARD_ROOM:
                return ballroomBilliardRoom;
            case BoardSpace.DINING_ROOM__KITCHEN:
                return diningRoomKitchen;
            case BoardSpace.BALLROOM__CONSERVATORY:
                return ballroomConservatory;
            case BoardSpace.BALLROOM__KITCHEN:
                return ballroomKitchen;
            default:
                throw new GameModelException(name);
        }
    }

    /*
    Operation name: GetSpaceConnections(space: BoardSpace):
Set<BoardSpace>
Input: The board space
Output: A set of board spaces that are connected to the input.
Description: Returns all of the board spaces that are connected to the
supplied space. These are the spaces that a character token can
move to from the input board space. For example, if the
supplied space is the Study. Then the connected board spaces
are hallways 1 and 3, and the Kitchen.
     */
    public Set<BoardSpace> getSpaceConnections(String name) throws GameModelException {
        Set<BoardSpace> connections = new HashSet<>();
        switch(name) {
            case BoardSpace.KITCHEN:
                connections.add(diningRoomKitchen);
                connections.add(ballroomKitchen);
                connections.add(study);
                return connections;
            case BoardSpace.BALLROOM:
                connections.add(ballroomBilliardRoom);
                connections.add(ballroomConservatory);
                connections.add(ballroomKitchen);
                return connections;
            case BoardSpace.CONSERVATORY:
                connections.add(conservatoryLibrary);
                connections.add(ballroomConservatory);
                connections.add(lounge);
                return connections;
            case BoardSpace.DINING_ROOM:
                connections.add(diningRoomKitchen);
                connections.add(diningRoomLounge);
                connections.add(billiardRoomDiningRoom);
                return connections;
            case BoardSpace.BILLIARD_ROOM:
                connections.add(billiardRoomDiningRoom);
                connections.add(billiardRoomHall);
                connections.add(billiardRoomLibrary);
                connections.add(ballroomBilliardRoom);
                return connections;
            case BoardSpace.LIBRARY:
                connections.add(libraryStudy);
                connections.add(billiardRoomLibrary);
                connections.add(conservatoryLibrary);
                return connections;
            case BoardSpace.LOUNGE:
                connections.add(hallLounge);
                connections.add(diningRoomLounge);
                connections.add(conservatory);
                return connections;
            case BoardSpace.HALL:
                connections.add(hallLounge);
                connections.add(hallStudy);
                connections.add(billiardRoomHall);
                return connections;
            case BoardSpace.STUDY:
                connections.add(hallStudy);
                connections.add(libraryStudy);
                connections.add(kitchen);
                return connections;
            case BoardSpace.SCARLET_START:
                connections.add(hallLounge);
                return connections;
            case BoardSpace.MUSTARD_START:
                connections.add(diningRoomLounge);
                return connections;
            case BoardSpace.WHITE_START:
                connections.add(ballroomKitchen);
                return connections;
            case BoardSpace.GREEN_START:
                connections.add(ballroomConservatory);
                return connections;
            case BoardSpace.PEACOCK_START:
                connections.add(conservatoryLibrary);
                return connections;
            case BoardSpace.PLUM_START:
                connections.add(libraryStudy);
                return connections;
            case BoardSpace.HALL__STUDY:
                connections.add(hall);
                connections.add(study);
                return connections;
            case BoardSpace.HALL__LOUNGE:
                connections.add(hall);
                connections.add(lounge);
                return connections;
            case BoardSpace.LIBRARY__STUDY:
                connections.add(library);
                connections.add(study);
                return connections;
            case BoardSpace.BILLIARD_ROOM__HALL:
                connections.add(billiardRoom);
                connections.add(hall);
                return connections;
            case BoardSpace.DINING_ROOM__LOUNGE:
                connections.add(diningRoom);
                connections.add(lounge);
                return connections;
            case BoardSpace.BILLIARD_ROOM__LIBRARY:
                connections.add(billiardRoom);
                connections.add(library);
                return connections;
            case BoardSpace.BILLIARD_ROOM__DINING_ROOM:
                connections.add(billiardRoom);
                connections.add(diningRoom);
                return connections;
            case BoardSpace.CONSERVATORY__LIBRARY:
                connections.add(conservatory);
                connections.add(library);
                return connections;
            case BoardSpace.BALLROOM__BILLIARD_ROOM:
                connections.add(ballroom);
                connections.add(billiardRoom);
                return connections;
            case BoardSpace.DINING_ROOM__KITCHEN:
                connections.add(diningRoom);
                connections.add(kitchen);
                return connections;
            case BoardSpace.BALLROOM__CONSERVATORY:
                connections.add(ballroom);
                connections.add(conservatory);
                return connections;
            case BoardSpace.BALLROOM__KITCHEN:
                connections.add(ballroom);
                connections.add(kitchen);
                return connections;
            default:
                throw new GameModelException(name);
        }
    }

    /*
Operation name: GetSpaceOccupants(space: BoardSpace):
12
Set<CharacterToken>
Input: The board space
Output: A set of all of the character tokens that currently occupy the
input board space
Description: Returns all of the characters that are present on the board
space. This operation must query all character tokens to see if
they are located on the input board space.
     */

    public Set<BoardSpace> getSpaceConnections(BoardSpace space) throws GameModelException {
        return getSpaceConnections(space.name);
    }

    public Set<Character> getSpaceOccupants(String name) {
        Set<Character> occupants = new HashSet<>();

        if (msScarlet.getSpace().name.equals(name)) {
            occupants.add(msScarlet);
        }

        if (colMustard.getSpace().name.equals(name)) {
            occupants.add(colMustard);
        }

        if (mrsWhite.getSpace().name.equals(name)) {
            occupants.add(mrsWhite);
        }

        if (mrGreen.getSpace().name.equals(name)) {
            occupants.add(mrGreen);
        }

        if (mrsPeacock.getSpace().name.equals(name)) {
            occupants.add(mrsPeacock);
        }

        if (profPlum.getSpace().name.equals(name)) {
            occupants.add(profPlum);
        }

        return occupants;
    }

    public Set<Character> getSpaceOccupants(BoardSpace space) {
        return getSpaceOccupants(space.name);
    }

    public Set<Weapon> getSpaceWeapons(String name) {
        Set<Weapon> weapons = new HashSet<>();

        if (candlestick.getSpace().name.equals(name)) {
            weapons.add(candlestick);
        }

        if (knife.getSpace().name.equals(name)) {
            weapons.add(knife);
        }

        if (pipe.getSpace().name.equals(name)) {
            weapons.add(pipe);
        }

        if (revolver.getSpace().name.equals(name)) {
            weapons.add(revolver);
        }

        if (rope.getSpace().name.equals(name)) {
            weapons.add(rope);
        }

        if (wrench.getSpace().name.equals(name)) {
            weapons.add(wrench);
        }

        return weapons;
    }

    public Set<Weapon> getSpaceWeapons(BoardSpace space) {
        return getSpaceWeapons(space.name);
    }

    public boolean isDirectedConnection(String from, String to) {
        boolean pathFound = false;
        try {
            Set<BoardSpace> connections = getSpaceConnections(from);
            for (BoardSpace space : connections) {
                if (space.name.equals(to)) {
                    pathFound = true;
                    break;
                }
            }
        } catch (GameModelException e) {
            // do nothing (return false)
        }
        return pathFound;
    }

    public boolean isDirectedConnection(BoardSpace from, BoardSpace to) {
        return isDirectedConnection(from.name, to.name);
    }

    public static Board initializeFromPayload(BoardPayload payload) throws GameModelException {
        Board board = new Board();

        board.msScarlet.setSpace(board.getBoardSpace(payload.getMsScarlet()));
        board.colMustard.setSpace(board.getBoardSpace(payload.getColMustard()));
        board.mrsWhite.setSpace(board.getBoardSpace(payload.getMrsWhite()));
        board.mrGreen.setSpace(board.getBoardSpace(payload.getMrGreen()));
        board.mrsPeacock.setSpace(board.getBoardSpace(payload.getMrsPeacock()));
        board.profPlum.setSpace(board.getBoardSpace(payload.getProfPlum()));

        board.candlestick.setSpace(board.getBoardSpace(payload.getCandlestick()));
        board.knife.setSpace(board.getBoardSpace(payload.getKnife()));
        board.pipe.setSpace(board.getBoardSpace(payload.getPipe()));
        board.revolver.setSpace(board.getBoardSpace(payload.getRevolver()));
        board.rope.setSpace(board.getBoardSpace(payload.getRope()));
        board.wrench.setSpace(board.getBoardSpace(payload.getWrench()));

        return board;
    }

    public void initialize() {
        initialize(true);
    }

    public void initialize(boolean random) {
        msScarlet.setSpace(scarletStart);
        colMustard.setSpace(mustardStart);
        mrsWhite.setSpace(whiteStart);
        mrGreen.setSpace(greenStart);
        mrsPeacock.setSpace(peacockStart);
        profPlum.setSpace(plumStart);

        List<Token> weapons = getAllWeapons();
        List<BoardSpace> rooms = getAllRooms();
        if (random) {
            Collections.shuffle(rooms);
        }
        for (Iterator<BoardSpace> iter = rooms.iterator(); iter.hasNext() && !weapons.isEmpty(); ) {
            Token weapon = weapons.remove(0);
            BoardSpace space = iter.next();
            weapon.setSpace(space);
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof Board) {
            Board other = (Board) obj;
            try {
                boolean sameScarlet = msScarlet.equals(other.getCharacter(Character.MS_SCARLET));
                boolean sameMustard = colMustard.equals(other.getCharacter(Character.COL_MUSTARD));
                boolean sameWhite = mrsWhite.equals(other.getCharacter(Character.MRS_WHITE));
                boolean sameGreen = mrGreen.equals(other.getCharacter(Character.MR_GREEN));
                boolean samePeacock = mrsPeacock.equals(other.getCharacter(Character.MRS_PEACOCK));
                boolean samePlum = profPlum.equals(other.getCharacter(Character.PROF_PLUM));
                boolean sameCharacters = sameScarlet && sameMustard && sameWhite && sameGreen && samePeacock && samePlum;

                boolean sameCandlestick = candlestick.equals(other.getWeapon(Weapon.CANDLESTICK));
                boolean sameKnife = knife.equals(other.getWeapon(Weapon.KNIFE));
                boolean samePipe = pipe.equals(other.getWeapon(Weapon.PIPE));
                boolean sameRevolver = revolver.equals(other.getWeapon(Weapon.REVOLVER));
                boolean sameRope = rope.equals(other.getWeapon(Weapon.ROPE));
                boolean sameWrench = wrench.equals(other.getWeapon(Weapon.WRENCH));
                boolean sameWeapons = sameCandlestick && sameKnife && samePipe && sameRevolver && sameRope && sameWrench;

                equal = sameCharacters && sameWeapons;
            } catch (GameModelException e) {
                logger.warn("Board has unexpected name");
                e.printStackTrace();
                // do nothing, leave equal set to false
            }
        }

        return equal;
    }

    public String toVisualString() {
        int size = 1600;

        List<Token> characters = getAllCharacters();
        List<Token> weapons = getAllWeapons();

        StringBuilder sb = new StringBuilder(size);
        sb.append(visualTopRooms(characters, weapons));
        sb.append(visualTopHalls(characters, weapons));
        sb.append(visualMiddleRooms(characters, weapons));
        sb.append(visualBottomHalls(characters, weapons));
        sb.append(visualBottomRooms(characters, weapons));

        sb.append("\n\n");

        StringJoiner sj = new StringJoiner("\n");
        for (Token token : characters) {
            sj.add(token.toString());
        }
        for (Token token : weapons) {
            sj.add(token.toString());
        }
        sb.append(sj);
        if (sj.length() > 0) {
            sb.append("\n");
        }
        return sb.toString();
    }

    private StringBuilder visualTopRooms(List<Token> characters, List<Token> weapons) {
        int size = 350;
        int roomWidth = 8;
        int hallwayWidth = 7;

        // TODO for future: Perhaps make visual string entirely dependent on parameters??
        StringBuilder visual = new StringBuilder(size);
        // Row 0
        visual.append("     St               Ha               Lo\n");
        // Row 1
        visual.append("  --------         --------    ");
        if (msScarlet.getSpace().equals(scarletStart)) {
            visual.append(msScarlet.toChar());
            characters.remove(msScarlet);
        } else {
            visual.append(" ");
        }
        visual.append("    --------\n");
        // Row 2
        visual.append(" |");
        visual.append(popNextShort(characters, study, roomWidth, 1, 4));
        visual.append("|-------|");
        visual.append(popNextShort(characters, hall, roomWidth, 1, 4));
        visual.append("|-------|");
        visual.append(popNextShort(characters, lounge, roomWidth, 1, 4));
        visual.append("|\n");
        // Row 3
        visual.append(" |");
        visual.append(popNextShort(characters, study, roomWidth, 1, 4));
        visual.append("|");
        visual.append(popNextShort(characters, hallStudy, hallwayWidth, 3, 1));
        visual.append("|");
        visual.append(popNextShort(characters, hall, roomWidth, 1, 4));
        visual.append("|");
        visual.append(popNextShort(characters, hallLounge, hallwayWidth, 3, 1));
        visual.append("|");
        visual.append(popNextShort(characters, lounge, roomWidth, 1, 4));
        visual.append("|\n");
        // Row 4
        visual.append(" |");
        visual.append(popNextShort(weapons, study, roomWidth, 5, 2));
        visual.append("|       |");
        visual.append(popNextShort(weapons, hall, roomWidth, 5, 2));
        visual.append("|       |");
        visual.append(popNextShort(weapons, lounge, roomWidth, 5, 2));
        visual.append("|\n");
        // Row 5
        visual.append(" |");
        visual.append(popNextShort(weapons, study, roomWidth, 3, 4));
        visual.append("|-------|");
        visual.append(popNextShort(weapons, hall, roomWidth, 3, 4));
        visual.append("|-------|");
        visual.append(popNextShort(weapons, lounge, roomWidth, 3, 4));
        visual.append("|\n");
        // Row 6
        visual.append("  --------         --------         --------\n");

        return visual;
    }

    private StringBuilder visualTopHalls(List<Token> characters, List<Token> weapons) {
        int size = 200;
        int hallwayWidth = 6;

        StringBuilder visual = new StringBuilder(size);
        // row 1
        visual.append("  |      |         |      |         |      |\n");
        // row 2
        if (profPlum.getSpace().equals(plumStart)) {
            visual.append(profPlum.toChar());
            characters.remove(profPlum);
        } else {
            visual.append(" ");
        }
        visual.append(" |");
        visual.append(popNextShort(characters, libraryStudy, hallwayWidth, 2, 1));
        visual.append("|         |");
        visual.append(popNextShort(characters, billiardRoomHall, hallwayWidth, 3, 1));
        visual.append("|         |      |\n");
        // row 3
        visual.append("  |      |         |      |         |");
        visual.append(popNextShort(characters, diningRoomLounge, hallwayWidth, 3, 1));
        visual.append("|");
        if (colMustard.getSpace().equals(mustardStart)) {
            visual.append(" ");
            visual.append(colMustard.toChar());
            visual.append("\n");
            characters.remove(colMustard);
        } else {
            visual.append("\n");
        }
        // row 4
        visual.append("  |      |         |      |         |      |\n");
        return visual;
    }

    private StringBuilder visualMiddleRooms(List<Token> characters, List<Token> weapons) {
        int size = 300;
        int roomWidth = 8;
        int hallwayWidth = 7;

        StringBuilder visual = new StringBuilder(size);
        // Row 1
        visual.append("  --------         --------         --------\n");
        // Row 2
        visual.append(" |");
        visual.append(popNextShort(characters, library, roomWidth, 1, 4));
        visual.append("|-------|");
        visual.append(popNextShort(characters, billiardRoom, roomWidth, 1, 4));
        visual.append("|-------|");
        visual.append(popNextShort(characters, diningRoom, roomWidth, 1, 4));
        visual.append("|\n");
        // Row 3
        visual.append("L|");
        visual.append(popNextShort(characters, library, roomWidth, 1, 4));
        visual.append("|");
        visual.append(popNextShort(characters, billiardRoomLibrary, hallwayWidth, 3, 1));
        visual.append("|");
        visual.append(popNextShort(characters, billiardRoom, roomWidth, 1, 4));
        visual.append("|");
        visual.append(popNextShort(characters, billiardRoomDiningRoom, hallwayWidth, 3, 1));
        visual.append("|");
        visual.append(popNextShort(characters, diningRoom, roomWidth, 1, 4));
        visual.append("|D\n");
        // Row 4
        visual.append("i|");
        visual.append(popNextShort(weapons, library, roomWidth, 5, 2));
        visual.append("|       |");
        visual.append(popNextShort(weapons, billiardRoom, roomWidth, 5, 2));
        visual.append("|       |");
        visual.append(popNextShort(weapons, diningRoom, roomWidth, 5, 2));
        visual.append("|i\n");
        // Row 5
        visual.append(" |");
        visual.append(popNextShort(weapons, library, roomWidth, 3, 4));
        visual.append("|-------|");
        visual.append(popNextShort(weapons, billiardRoom, roomWidth, 3, 4));
        visual.append("|-------|");
        visual.append(popNextShort(weapons, diningRoom, roomWidth, 3, 4));
        visual.append("|\n");
        // Row 6
        visual.append("  --------         -------- Bi      --------\n");
        return visual;
    }

    private StringBuilder visualBottomHalls(List<Token> characters, List<Token> weapons) {
        int size = 200;
        int hallwayWidth = 6;

        StringBuilder visual = new StringBuilder(size);
        // row 1
        visual.append("  |      |         |      |         |      |\n");
        // row 2
        if (mrsPeacock.getSpace().equals(peacockStart)) {
            visual.append(mrsPeacock.toChar());
            characters.remove(mrsPeacock);
        } else {
            visual.append(" ");
        }
        visual.append(" |");
        visual.append(popNextShort(characters, conservatoryLibrary, hallwayWidth, 2, 1));
        visual.append("|         |");
        visual.append(popNextShort(characters, ballroomBilliardRoom, hallwayWidth, 3, 1));
        visual.append("|         |      |\n");
        // row 3
        visual.append("  |      |         |      |         |");
        visual.append(popNextShort(characters, diningRoomKitchen, hallwayWidth, 3, 1));
        visual.append("|\n");
        // row 4
        visual.append("  |      |         |      |         |      |\n");
        return visual;
    }

    private StringBuilder visualBottomRooms(List<Token> characters, List<Token> weapons) {
        int size = 350;
        int roomWidth = 8;
        int hallwayWidth = 7;

        StringBuilder visual = new StringBuilder(size);
        // Row 1
        visual.append("  --------         --------         --------\n");
        // Row 2
        visual.append(" |");
        visual.append(popNextShort(characters, conservatory, roomWidth, 1, 4));
        visual.append("|-------|");
        visual.append(popNextShort(characters, ballroom, roomWidth, 1, 4));
        visual.append("|-------|");
        visual.append(popNextShort(characters, kitchen, roomWidth, 1, 4));
        visual.append("|\n");
        // Row 3
        visual.append(" |");
        visual.append(popNextShort(characters, conservatory, roomWidth, 1, 4));
        visual.append("|       |");
        visual.append(popNextShort(characters, hall, roomWidth, 1, 4));
        visual.append("|       |");
        visual.append(popNextShort(characters, lounge, roomWidth, 1, 4));
        visual.append("|\n");
        // Row 4
        visual.append(" |");
        visual.append(popNextShort(weapons, conservatory, roomWidth, 5, 2));
        visual.append("|");
        visual.append(popNextShort(characters, ballroomConservatory, hallwayWidth, 3, 1));
        visual.append("|");
        visual.append(popNextShort(weapons, ballroom, roomWidth, 5, 2));
        visual.append("|");
        visual.append(popNextShort(characters, ballroomKitchen, hallwayWidth, 3, 1));
        visual.append("|");
        visual.append(popNextShort(weapons, kitchen, roomWidth, 5, 2));
        visual.append("|\n");
        // Row 5
        visual.append(" |");
        visual.append(popNextShort(weapons, conservatory, roomWidth, 3, 4));
        visual.append("|-------|");
        visual.append(popNextShort(weapons, ballroom, roomWidth, 3, 4));
        visual.append("|-------|");
        visual.append(popNextShort(weapons, kitchen, roomWidth, 3, 4));
        visual.append("|\n");
        // Row 6
        visual.append("  --------    ");
        if (mrGreen.getSpace().equals(greenStart)) {
            visual.append(mrGreen.toChar());
            characters.remove(mrGreen);
        } else {
            visual.append(" ");
        }
        visual.append("    --------    ");
        if (mrsWhite.getSpace().equals(whiteStart)) {
            visual.append(mrsWhite.toChar());
            characters.remove(mrsWhite);
        } else {
            visual.append(" ");
        }
        visual.append("    --------\n");
        // Row 7
        visual.append("     Co               Ba               Ki");

        return visual;
    }

    private String popNextShort(List<Token> list, BoardSpace space, int width, int start, int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < start; i++) {
            sb.append(" ");
        }
        int j = 0;
        for(Iterator<Token> iter = list.iterator(); iter.hasNext() && j < n; ) {
            Token token = iter.next();
            if (token.getSpace().equals(space)) {
                iter.remove();
                j++;
                sb.append(token.toChar());
            }
        }
        for (int i = j + start; i < width; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
