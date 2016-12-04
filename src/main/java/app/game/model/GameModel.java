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

    private void initialize() {
        createMurderAndDealCards();
        initializeTurns();
        initializeWasMoved();
    }

    private void createMurderAndDealCards() {
        Dealer.DealResult result = dealer.deal(players.size());
        murder = result.murder;
        for(Player player : players) {
            List<Card> hand = result.hands.remove(0);
            player.setHand(hand);
        }
    }

    private void initializeTurns() {
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

    private void initializeWasMoved() {
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

    public void endTurn() {
        wasMoved.put(turn.getWho().getCharacter(), false);
        turn.nextTurn(getNextTurn());
    }

    private Player getNextTurn() {
        for (Iterator<Player> iter = turnOrder.iterator(); iter.hasNext(); ) {
            Player player = iter.next();
            if ((player == turn.getWho()) && iter.hasNext()) {
                return iter.next();
            }
        }
        return turnOrder.get(0);
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

    public boolean allPlayersSet() {
        boolean allSet = true;
        for (Player player : players) {
            if (player.getCharacter() == null) {
                allSet = false;
                break;
            }
        }
        return allSet;
    }

    public String toVisualString() {
        StringBuilder sb = new StringBuilder();
        sb.append(board.toVisualString());
        //sb.append("\n\n");
        sb.append(turn.toVisualString());
        sb.append("\n\n");
        for (Player player : players) {
            sb.append(player.toVisualString());
            sb.append("\n");
        }
        List<String> moved = new ArrayList<>();
        for (Map.Entry<Character, Boolean> entry : wasMoved.entrySet()) {
            if (entry.getValue()) {
                moved.add(entry.getKey().getName());
            }
        }
        if (!moved.isEmpty()) {
            sb.append("Was moved by suggestion: ");
            sb.append(String.join(", ", moved));
            sb.append("\n");
        }
        if (!players.isEmpty() || !moved.isEmpty()) {
            sb.append("\n");
        }
        sb.append(murder.toVisualString());
        return sb.toString();
    }
}
