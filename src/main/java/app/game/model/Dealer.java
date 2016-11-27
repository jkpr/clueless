package app.game.model;

import app.exception.GameModelException;

import java.util.*;

/**
 * Created by james on 11/27/16.
 */
public class Dealer {
    private final Card KITCHEN = new Card(BoardSpace.KITCHEN);
    private final Card BALLROOM = new Card(BoardSpace.BALLROOM);
    private final Card CONSERVATORY = new Card(BoardSpace.CONSERVATORY);
    private final Card DINING_ROOM = new Card(BoardSpace.DINING_ROOM);
    private final Card BILLIARD_ROOM = new Card(BoardSpace.BILLIARD_ROOM);
    private final Card LIBRARY = new Card(BoardSpace.LIBRARY);
    private final Card LOUNGE = new Card(BoardSpace.LOUNGE);
    private final Card HALL = new Card(BoardSpace.HALL);
    private final Card STUDY = new Card(BoardSpace.STUDY);

    private final Card MS_SCARLET = new Card(CharacterToken.MS_SCARLET);
    private final Card COL_MUSTARD = new Card(CharacterToken.COL_MUSTARD);
    private final Card MRS_WHITE = new Card(CharacterToken.MRS_WHITE);
    private final Card MR_GREEN = new Card(CharacterToken.MR_GREEN);
    private final Card MRS_PEACOCK = new Card(CharacterToken.MRS_PEACOCK);
    private final Card PROF_PLUM = new Card(CharacterToken.PROF_PLUM);

    private final Card CANDLESTICK = new Card(WeaponToken.CANDLESTICK);
    private final Card KNIFE = new Card(WeaponToken.KNIFE);
    private final Card PIPE = new Card(WeaponToken.PIPE);
    private final Card REVOLVER = new Card(WeaponToken.REVOLVER);
    private final Card ROPE = new Card(WeaponToken.ROPE);
    private final Card WRENCH = new Card(WeaponToken.WRENCH);

    public Dealer() throws GameModelException {}

    public DealResult deal(int nPlayer) {
        DealResult result = new DealResult();

        List<Card> characters = getCharactersList();
        List<Card> weapons = getWeaponsList();
        List<Card> rooms = getRoomsList();

        result.murderCharacter = randomPop(characters);
        result.murderWeapon = randomPop(weapons);
        result.murderRoom = randomPop(rooms);

        List<Card> allRemaining = new LinkedList<>();
        allRemaining.addAll(characters);
        allRemaining.addAll(weapons);
        allRemaining.addAll(rooms);

        // shuffle in place
        Collections.shuffle(allRemaining);

        result.hands = new ArrayList<>(nPlayer);
        for (int i = 0; i < nPlayer; i++) {
            result.hands.add(new HashSet<>());
        }
        // round-robin deal
        for (int i = 0; i < allRemaining.size(); i++) {
            Card next = allRemaining.get(i);
            result.hands.get(i % nPlayer).add(next);
        }

        return result;
    }

    private Card randomPop(List<Card> list) {
        Random random = new Random();
        int choice = random.nextInt(list.size());
        Card chosen = list.remove(choice);
        return chosen;
    }

    private List<Card> getRoomsList() {
        List<Card> rooms = new LinkedList<>();
        rooms.add(KITCHEN);
        rooms.add(BALLROOM);
        rooms.add(CONSERVATORY);
        rooms.add(DINING_ROOM);
        rooms.add(BILLIARD_ROOM);
        rooms.add(LIBRARY);
        rooms.add(LOUNGE);
        rooms.add(HALL);
        rooms.add(STUDY);
        return rooms;
    }

    private List<Card> getCharactersList() {
        List<Card> characters = new LinkedList<>();
        characters.add(MS_SCARLET);
        characters.add(COL_MUSTARD);
        characters.add(MRS_WHITE);
        characters.add(MR_GREEN);
        characters.add(MRS_PEACOCK);
        characters.add(PROF_PLUM);
        return characters;
    }

    private List<Card> getWeaponsList() {
        List<Card> weapons = new LinkedList<>();
        weapons.add(CANDLESTICK);
        weapons.add(KNIFE);
        weapons.add(PIPE);
        weapons.add(REVOLVER);
        weapons.add(ROPE);
        weapons.add(WRENCH);
        return weapons;
    }

    public Card getCard(String name) {
        // TODO: return card just as in Board.getBoardSpace
        return null;
    }

    class DealResult {
        Card murderCharacter;
        Card murderWeapon;
        Card murderRoom;

        List<Set<Card>> hands;
    }
}
