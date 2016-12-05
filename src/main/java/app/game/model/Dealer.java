package app.game.model;

import app.exception.GameModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by james on 11/27/16.
 */
public class Dealer {
    private static final Logger logger = LoggerFactory.getLogger(Dealer.class);

    private Card msScarlet;
    private Card colMustard;
    private Card mrsWhite;
    private Card mrGreen;
    private Card mrsPeacock;
    private Card profPlum;

    private Card candlestick;
    private Card knife;
    private Card pipe;
    private Card revolver;
    private Card rope;
    private Card wrench;

    private Card kitchen;
    private Card ballroom;
    private Card conservatory;
    private Card diningRoom;
    private Card billiardRoom;
    private Card library;
    private Card lounge;
    private Card hall;
    private Card study;

    public Dealer() {
        try {
            kitchen = new Card(BoardSpace.KITCHEN);
            ballroom = new Card(BoardSpace.BALLROOM);
            conservatory = new Card(BoardSpace.CONSERVATORY);
            diningRoom = new Card(BoardSpace.DINING_ROOM);
            billiardRoom = new Card(BoardSpace.BILLIARD_ROOM);
            library = new Card(BoardSpace.LIBRARY);
            lounge = new Card(BoardSpace.LOUNGE);
            hall = new Card(BoardSpace.HALL);
            study = new Card(BoardSpace.STUDY);
            msScarlet = new Card(Character.MS_SCARLET);
            colMustard = new Card(Character.COL_MUSTARD);
            mrsWhite = new Card(Character.MRS_WHITE);
            mrGreen = new Card(Character.MR_GREEN);
            mrsPeacock = new Card(Character.MRS_PEACOCK);
            profPlum = new Card(Character.PROF_PLUM);
            candlestick = new Card(Weapon.CANDLESTICK);
            knife = new Card(Weapon.KNIFE);
            pipe = new Card(Weapon.PIPE);
            revolver = new Card(Weapon.REVOLVER);
            rope = new Card(Weapon.ROPE);
            wrench = new Card(Weapon.WRENCH);
        } catch (GameModelException e) {
            logger.error("Error thrown while constructing Dealer. Should never happen...");
        }
    }

    public DealResult deal(int nPlayer) {
        // TODO ensure 3 <= nPlayer <= 6
        DealResult result = new DealResult();

        List<Card> characters = getCharactersList();
        List<Card> weapons = getWeaponsList();
        List<Card> rooms = getRoomsList();

        Card murderCharacter = randomPop(characters);
        Card murderWeapon = randomPop(weapons);
        Card murderRoom = randomPop(rooms);
        result.murder = new Murder(murderCharacter, murderWeapon, murderRoom);

        List<Card> allRemaining = new LinkedList<>();
        allRemaining.addAll(characters);
        allRemaining.addAll(weapons);
        allRemaining.addAll(rooms);

        // shuffle in place
        Collections.shuffle(allRemaining);

        result.hands = new ArrayList<>(nPlayer);
        for (int i = 0; i < nPlayer; i++) {
            result.hands.add(new LinkedList<>());
        }
        // round-robin deal
        for (int i = 0; i < allRemaining.size(); i++) {
            Card next = allRemaining.get(i);
            result.hands.get(i % nPlayer).add(next);
        }
        Collections.shuffle(result.hands);

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
        rooms.add(kitchen);
        rooms.add(ballroom);
        rooms.add(conservatory);
        rooms.add(diningRoom);
        rooms.add(billiardRoom);
        rooms.add(library);
        rooms.add(lounge);
        rooms.add(hall);
        rooms.add(study);
        return rooms;
    }

    private List<Card> getCharactersList() {
        List<Card> characters = new LinkedList<>();
        characters.add(msScarlet);
        characters.add(colMustard);
        characters.add(mrsWhite);
        characters.add(mrGreen);
        characters.add(mrsPeacock);
        characters.add(profPlum);
        return characters;
    }

    private List<Card> getWeaponsList() {
        List<Card> weapons = new LinkedList<>();
        weapons.add(candlestick);
        weapons.add(knife);
        weapons.add(pipe);
        weapons.add(revolver);
        weapons.add(rope);
        weapons.add(wrench);
        return weapons;
    }

    public Card getCard(String name) throws GameModelException{
        // TODO: return card just as in Board.getBoardSpace
        switch(name){
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

    class DealResult {
        Murder murder;
        List<List<Card>> hands;
    }
}
