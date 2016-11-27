package app.game;

import java.util.*;

import static app.game.BoardSpace.*;

/**
 * Created by james on 11/26/16.
 */
public class Board {

    Map<Integer, Set<Integer>> spaceConnections;

    public Board() {
        spaceConnections = new HashMap<>();
        initializeRoomConnections();
        initializeHallwayConnections();
        initializeStartSpaceConnections();
    }

    private void initializeRoomConnections() {
        // kitchen -> one room, two hallways
        Integer[] kitchenList = {STUDY, DINING_ROOM__KITCHEN, BALLROOM__KITCHEN};
        spaceConnections.put(KITCHEN, new HashSet<>(Arrays.asList(kitchenList)));

        // ... and so on for the rest of the rooms
    }

    private void initializeHallwayConnections() {

    }

    private void initializeStartSpaceConnections() {

    }

}
