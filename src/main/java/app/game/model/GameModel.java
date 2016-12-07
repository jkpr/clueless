package app.game.model;

import app.exception.GameModelException;
import app.json.GameModelPayload;
import app.json.PlayerPayload;
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
    private Player winner;

    public GameModel() {
        dealer = new Dealer();
        board = new Board();
        board.initialize();
        players = new LinkedList<>();
        history = new History();
        murder = null;
        status = GameStatus.SETUP;
        turn = new Turn();
        turnOrder = new LinkedList<>();
        // TODO: make this more elegant
        wasMoved = new HashMap<>();
        initializeWasMoved();
        
        winner = null;
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

    public void setMurder(Murder murder) {
        this.murder = murder;
    }

    public History getHistory() {
        return history;
    }

    public Turn getTurn() {
        return turn;
    }

    public List<Player> getTurnOrder() {
        return turnOrder;
    }

    public void removeFromTurnOrder(Player player) {
        turnOrder.remove(player);
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

    // create for brand new, initialize to setup existing
    public static GameModel createFromPayload(GameModelPayload payload) throws GameModelException {
        GameModel model = new GameModel();
        // Board
        model.board.initializeFromPayload(payload.getBoard());
        // Players
        for (PlayerPayload playerPayload : payload.getPlayers()) {
            Player player = new Player();
            player.setCharacter(model.board.getCharacter(playerPayload.getCharacter()));
            for (String card : playerPayload.getHand()) {
                player.acceptCard(model.dealer.getCard(card));
            }
            model.addPlayer(player);
        }
        // Murder
        Card character = model.dealer.getCard(payload.getMurder().getCharacter());
        Card weapon = model.dealer.getCard(payload.getMurder().getWeapon());
        Card room = model.dealer.getCard(payload.getMurder().getRoom());
        Murder murder = new Murder(character, weapon, room);
        model.setMurder(murder);
        // TODO Make sure all the cards are dealt, if not throw GameModelException
        // Turn order
        for (String name : payload.getTurnOrder()) {
            Player player = model.getPlayerByCharacter(model.board.getCharacter(name));
            if (player == null) {
                throw new GameModelException();
            }
            model.turnOrder.add(player);
        }
        // TODO make sure the turn order is correct
        // Turn
        model.turn.setWho(model.getPlayerByCharacter(model.board.getCharacter(payload.getTurn().getWho())));
        model.turn.setHasMoved(payload.getTurn().getHasMoved());
        model.turn.setHasSuggested(payload.getTurn().getHasSuggested());
        model.turn.setWhoCanDisprove(model.getPlayerByCharacter(model.board.getCharacter(payload.getTurn().getWhoCanDisprove())));
        model.turn.setSuggestedCharacter(model.dealer.getCard(payload.getTurn().getSuggestedCharacter()));
        model.turn.setSuggestedWeapon(model.dealer.getCard(payload.getTurn().getSuggestedWeapon()));
        model.turn.setSuggestedRoom(model.dealer.getCard(payload.getTurn().getSuggestedRoom()));


        // TODO implement History sometime

        // Game status
        model.status = payload.getStatus();

        // Was moved
        for (Map.Entry<String, Boolean> entry : payload.getWasMoved().entrySet()) {
            Character token = model.getBoard().getCharacter(entry.getKey());
            model.wasMoved.put(token, entry.getValue());
        }
        // TODO make sure all characters are in there

        return model;
    }

    public GameModelPayload toPayload() {
        GameModelPayload payload = new GameModelPayload();
        payload.setStatus(status);
        payload.setBoard(board.toPayload());
        List<PlayerPayload> playerPayloads = new ArrayList<>();
        for (Player player : players) {
            playerPayloads.add(player.toPayload());
        }
        payload.setPlayers(playerPayloads);
        if (murder != null) {
            payload.setMurder(murder.toPayload());
        }
        List<String> turnOrderString = new ArrayList<>();
        for (Player player : turnOrder) {
            turnOrderString.add(player.getCharacter().getName());
        }
        payload.setTurnOrder(turnOrderString);
        payload.setTurn(turn.toPayload());

        payload.setWasMoved(new HashMap<>());
        for (Map.Entry<Character, Boolean> entry : wasMoved.entrySet()) {
            payload.getWasMoved().put(entry.getKey().getName(), entry.getValue());
        }

        // TODO history
        return payload;
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
        if (murder != null) {
            sb.append(murder.toVisualString());
        }
        return sb.toString();
    }

    public boolean wasMoved(Character character) {
        return wasMoved.get(character);
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getWhoCanDisprove(Card character, Card weapon, Card room) {
        List<Player> playersSuggestion = new ArrayList<>();

        Player currentPlayer = turn.getWho();
        Iterator<Player> iter = players.iterator();
        while (iter.hasNext()) {
            Player player = iter.next();
            if (player == currentPlayer) {
                break;
            }
        }

        // loop back to the beginning
        if (!iter.hasNext()) {
            iter = players.iterator();
        }

        while (iter.hasNext()) {
            Player player = iter.next();
            if (player == currentPlayer) {
                break;
            }
            playersSuggestion.add(player);
            List<Card> hand = player.getHand();
            if (hand.contains(character) || hand.contains(weapon) || hand.contains(room)) {
                return playersSuggestion;
            }
            // loop back to the beginning
            if (!iter.hasNext()) {
                iter = players.iterator();
            }
        }
        // No one found
        return null;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
