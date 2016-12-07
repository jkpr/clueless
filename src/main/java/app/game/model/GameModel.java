package app.game.model;

import app.exception.GameModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by james on 11/26/16.
 */
public class GameModel {
    private static final Logger logger = LoggerFactory.getLogger(GameModel.class);

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

    /*
    Operation name: InitializeModel()
Input: void
Output: void
Description: Initializes the board, places the character tokens on their
assigned board spaces, and places the weapon tokens
randomly on rooms, at most one weapon per room.
     */

    private void initialize() {
        createMurderAndDealCards();
        initializeTurns();
        initializeWasMoved();
    }

    /*
    Operation name: CreateMurderAndDealCards()
Input: void
Output: void
Description: This is called by the “StartGame” action. The murder is a
randomly selected room, weapon, and character card. The
remaining eighteen cards are shuffled and dealt to the players.
The dealing begins with a random player and continues
clockwise around the board. It is possible that some players
will have more cards than others.
     */

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
    public boolean getWasMoved(Player player){

        boolean wasMoved = false;

        BoardSpace currentSpace = player.getCharacter().getSpace();

        return wasMoved;
        //Set<BoardSpace> connections = getBoard().getSpaceConnections();

    }


    public String toVisualString() {
        logger.info("toVisualString: 1");
        StringBuilder sb = new StringBuilder();
        sb.append(board.toVisualString());
        logger.info("toVisualString: 2");
        //sb.append("\n\n");
        sb.append(turn.toVisualString());
        logger.info("toVisualString: 3");
        sb.append("\n\n");
        for (Player player : players) {
            sb.append(player.toVisualString());
            sb.append("\n");
        }
        logger.info("toVisualString: 4");
        List<String> moved = new ArrayList<>();
        for (Map.Entry<Character, Boolean> entry : wasMoved.entrySet()) {
            if (entry.getValue()) {
                moved.add(entry.getKey().getName());
            }
        }
        logger.info("toVisualString: 5");
        if (!moved.isEmpty()) {
            sb.append("Was moved by suggestion: ");
            sb.append(String.join(", ", moved));
            sb.append("\n");
        }
        logger.info("toVisualString: 6");
        if (!players.isEmpty() || !moved.isEmpty()) {
            sb.append("\n");
        }
        logger.info("toVisualString: 7");
        if (murder != null) {
            sb.append(murder.toVisualString());
        }
        logger.info("toVisualString: 8");
        return sb.toString();
    }
}
