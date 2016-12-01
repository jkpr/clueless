package app.game.model;

import app.exception.GameModelException;

import java.util.*;

/**
 * Created by james on 11/26/16.
 */
public class GameModel {
    public static final int MIN_PLAYERS = 3;
    public static final int MAX_PLAYERS = 6;

    private Dealer dealer;
    private Board board;
    private List<Player> players;
    private History history;
    private Murder murder;
    private GameStatus status;
    private Turn turn;
    private List<Player> turnOrder;
    // TODO: make this more elegant (check history for moves)
    private Map<Character, Boolean> wasMoved;

    public GameModel() {
        dealer = new Dealer();
        board = new Board();
        players = new LinkedList<>();
        history = new History();
        murder = null;
        status = GameStatus.SETUP;
        turn = new Turn();
        turnOrder = new LinkedList<>();
        // TODO: make this more elegant
        wasMoved = new HashMap<>();
        
        board.initialize();
    }

    public Player getPlayerByCharacter(Character character) {
        for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
            Player next = iter.next();
            // TODO: Maybe need to get by character name
            if (next.getCharacter().equals(character)) {
                return next;
            }
        }
        return null;
    }

    public void startGame() {
        initialize();
        status = GameStatus.ACTIVE;
    }

    public void initialize() {
        createMurderAndDealCards();
        initializeTurns();
        initializeWasMoved();
    }

    public void createMurderAndDealCards() {
        Dealer.DealResult result = dealer.deal(players.size());
        murder = result.murder;
        for(Player player : players) {
            List<Card> hand = result.hands.remove(0);
            player.setHand(hand);
        }
    }

    public void initializeTurns() {
        turnOrder.clear();
        try {
            Player msScarlet = getPlayerByCharacter(board.getCharacter(Character.MS_SCARLET));
            Player colMustard = getPlayerByCharacter(board.getCharacter(Character.COL_MUSTARD));
            Player mrsWhite = getPlayerByCharacter(board.getCharacter(Character.MRS_WHITE));
            Player mrGreen = getPlayerByCharacter(board.getCharacter(Character.MR_GREEN));
            Player mrsPeacock = getPlayerByCharacter(board.getCharacter(Character.MRS_PEACOCK));
            Player profPlum = getPlayerByCharacter(board.getCharacter(Character.PROF_PLUM));
            if (msScarlet != null) {
                turnOrder.add(msScarlet);
            }
            if (colMustard != null) {
                turnOrder.add(colMustard);
            }
            if (mrsWhite != null) {
                turnOrder.add(mrsWhite);
            }
            if (mrGreen != null) {
                turnOrder.add(mrGreen);
            }
            if (mrsPeacock != null) {
                turnOrder.add(mrsPeacock);
            }
            if (profPlum != null) {
                turnOrder.add(profPlum);
            }
            turn.nextTurn(turnOrder.get(0));
        } catch (GameModelException e) {
            // should never happen
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            // should never happen because the action ensures there are players first
            e.printStackTrace();
        }
    }

    public void initializeWasMoved() {
        try {
            wasMoved = new HashMap<>();
            wasMoved.put(board.getCharacter(Character.MS_SCARLET), false);
            wasMoved.put(board.getCharacter(Character.COL_MUSTARD), false);
            wasMoved.put(board.getCharacter(Character.MRS_WHITE), false);
            wasMoved.put(board.getCharacter(Character.MR_GREEN), false);
            wasMoved.put(board.getCharacter(Character.MRS_PEACOCK), false);
            wasMoved.put(board.getCharacter(Character.PROF_PLUM), false);
        } catch (GameModelException e) {
            // should never happen
            e.printStackTrace();
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public Board getBoard() {
        return board;
    }

    public Murder getMurder() {
        return murder;
    }

    public History getHistory() {
        return history;
    }

    public Turn getTurn() {
        return turn;
    }


}
